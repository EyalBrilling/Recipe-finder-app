from enum import Enum


class Quantity(Enum):
    BELOW_AVERAGE = 0
    ABOVE_AVERAGE = 1
    LOW = 2
    HIGH = 3


def merge_clause(clauses: list):
    if len(clauses) == 0:
        return ''

    return 'WHERE ' + ' AND '.join(clauses)


def merge_from(from_list: list):
    return 'FROM ' + ', '.join(from_list)


def search_recipe(category: str = None, ingredient: str = None,
                  nutrition: str = None, nutrition_quantity: Quantity = None):
    clauses = []
    from_list = ['recipes']

    if ingredient:
        from_list.append('recipe_ingredients')
        clauses.append('recipes.Id = recipe_ingredients.RecipeId')
        clauses.append(f'recipe_ingredients.IngredientId = (SELECT Id FROM ingredients '
                       f'WHERE ingredients.IngredientName = "{ingredient}")')

    if category:
        clauses.append(f'recipes.RecipeCategory = "{category}"')

    if nutrition:
        from_list.append('nutrition')
        clauses.append('recipes.Id = nutrition.RecipeId')

        condition_dict = {Quantity.ABOVE_AVERAGE: '>= (SELECT AVG', Quantity.BELOW_AVERAGE: '<= (SELECT AVG',
                          Quantity.LOW: '= (SELECT MIN', Quantity.HIGH: '= (SELECT MAX'}

        merged_clauses = merge_clause(clauses)
        merged_from = merge_from(from_list)
        clauses.append(f'nutrition.{nutrition}{condition_dict[Quantity(nutrition_quantity)]}'
                       f'(nutrition.{nutrition}) {merged_from} {merged_clauses})')

    return f'SELECT recipes.* {merge_from(from_list)} {merge_clause(clauses)}'


def update_recipe(recipe_id, prep_time=str, cook_time=str):
    return f'UPDATE recipes SET recipes.PrepTime = "{prep_time}", recipes.CookTime = "{cook_time}" ' \
           f'WHERE recipes.Id = {recipe_id}'


def insert_user(username, password, age, sex, height, weight):
    return f'INSERT INTO users (Username, Password, Age, Sex, Height ,Weight) VALUES (' \
           f'"{username}","{password}",{age},{sex},{height},{weight})'


def check_user(username, password):
    return f'SELECT * FROM users WHERE users.Username ="{username}" AND users.Password ="{password}"'

