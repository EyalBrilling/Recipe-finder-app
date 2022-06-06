import pandas as pd
from tqdm import tqdm
import numpy as np

df_unique = pd.read_csv('../data/unique_ingredients.csv', dtype={'IngredientName': object, 'IngredientId': int})


def name2id(name):
    try:
        return df_unique.loc[df_unique.IngredientName == name].IngredientId.iloc[0]
    except IndexError:
        return None


def main():
    chunk_size = 5000
    for i, chunk in enumerate(tqdm(pd.read_csv('../data/ingredients.csv',
                                               dtype={'RecipeId': int, 'Ingredient': object, 'Quantity': float},
                                               chunksize=chunk_size))):
        if i == 0:
            header = True
            mode = 'w'
        else:
            header = False
            mode = 'a'

        chunk['IngredientId'] = chunk.Ingredient.apply(name2id)
        chunk.dropna(inplace=True)
        chunk[['RecipeId', 'IngredientId', 'Quantity']].to_csv('../data/ingredients_by_id.csv', mode=mode, header=header, index=False)


if __name__ == '__main__':
    main()
