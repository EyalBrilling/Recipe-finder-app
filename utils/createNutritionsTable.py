import pandas as pd
from tqdm import tqdm


def convert_to_float(frac_str):
    try:
        try:
            frac_str = frac_str.split('-')[0].strip()
            return float(frac_str)
        except ValueError:
            try:
                num, denom = frac_str.split('/')
            except ValueError:
                print(frac_str)
                return None
            try:
                leading, num = num.split(' ')
                whole = float(leading)
            except ValueError:
                whole = 0
            frac = float(num) / float(denom)
            return whole - frac if whole < 0 else whole + frac
    except ValueError:
        return None


def to_float(s):
    if s == 'NA':
        return None
    return convert_to_float(s)


def sep_ingredients(s):
    s = str(s)
    try:
        ingredients = s.split('(')[1].split(')')[0].split(",")
        return [ingredient.replace('"', '').strip() for ingredient in ingredients]
    except IndexError:
        return [s.replace('"', '')]


def process_chunk(chunk):
    df_out = pd.DataFrame(columns=['RecipeId', 'RecipeIngredientParts', 'RecipeIngredientQuantities'])

    for index, row in chunk.iterrows():
        id = row['RecipeId']
        ingredients = row['RecipeIngredientParts']
        quantities = row['RecipeIngredientQuantities']
        for ingredient, quantity in zip(ingredients, quantities):
            df_out.loc[df_out.shape[0]] = [id, ingredient, to_float(quantity)]

    return df_out


def main():
    df = pd.read_csv('../ingredients.csv', dtype={'RecipeId': int, 'RecipeIngredientParts': object,
                                               'RecipeIngredientQuantities': object})
    df["RecipeIngredientParts"] = df["RecipeIngredientParts"].apply(sep_ingredients)
    df["RecipeIngredientQuantities"] = df["RecipeIngredientQuantities"].apply(sep_ingredients)


    chunk_size = 50
    length = df.shape[0]
    num_chunks = int(length / chunk_size) + 1

    for i in tqdm(range(num_chunks)):
        chunk = df[(i * chunk_size):(min((i+1) * chunk_size, length))]
        out = process_chunk(chunk)
        if i == 0:
            header = True
            mode = 'w'
        else:
            header = False
            mode = 'a'
        out.to_csv('ingredients_seperated.csv', mode=mode, header=header, index=False)


if __name__ == '__main__':
    main()