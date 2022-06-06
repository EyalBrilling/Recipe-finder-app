import pandas as pd
from tqdm import tqdm
import numpy as np


def main():
    chunk_size = 500
    for i, chunk in enumerate(tqdm(pd.read_csv('../data/ingredients.csv', dtype={'RecipeId': int, 'Ingredient': object,
                                                                                 'Quantity': float},
                                               chunksize=chunk_size))):
        if i == 0:
            unique_ingredients_np = chunk.Ingredient.unique()
        else:
            unique_ingredients_np = np.unique(np.append(unique_ingredients_np, chunk.Ingredient.unique()))
    unique_ingredients = pd.Series(unique_ingredients_np[6:], name='IngredientName')
    unique_ingredients = unique_ingredients.rename_axis('IngredientId').reset_index()
    unique_ingredients.to_csv('../data/unique_ingredients.csv', index=False)


if __name__ == '__main__':
    main()
