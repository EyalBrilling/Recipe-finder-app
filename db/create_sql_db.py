import csv

import pandas as pd
from tqdm import tqdm

from db.db_connection import connect_to_db, disconnect, execute_query


def create_tables(db, cursor, tables_queries):
    for query in tables_queries:
        execute_query(db, cursor, query)

    execute_query(db, cursor, "SHOW TABLES", commit=False)
    print("Created tables:")
    for table_name in cursor:
        print(table_name[0])


def create_tables_queries():
    queries = []

    users_query = \
        """
        CREATE TABLE IF NOT EXISTS users (
                Id INT UNSIGNED AUTO_INCREMENT NOT NULL , 
                Username VARCHAR(100) NOT NULL,
                Password VARCHAR(200) NOT NULL,
                Age TINYINT UNSIGNED NOT NULL,
                Sex BOOL NOT NULL,
                Height TINYINT UNSIGNED NOT NULL,
                Weight TINYINT UNSIGNED NOT NULL,
                PRIMARY KEY (Id))
                """
    queries.append(users_query)

    recipes_query = \
        """
        CREATE TABLE IF NOT EXISTS recipes (
                Id MEDIUMINT UNSIGNED NOT NULL, 
                RecipeName VARCHAR(155) NOT NULL,
                CookTime VARCHAR(15),
                PrepTime VARCHAR(15) NOT NULL,
                Images TEXT,
                RecipeCategory VARCHAR(75),
                RecipeInstructions TEXT,
                PRIMARY KEY (Id))
                """
    queries.append(recipes_query)

    nutrition_query = \
        """
        CREATE TABLE IF NOT EXISTS nutrition (
                RecipeId MEDIUMINT UNSIGNED NOT NULL ,
                Calories FLOAT UNSIGNED NOT NULL,
                Fat  FLOAT UNSIGNED NOT NULL,
                SaturatedFat  FLOAT UNSIGNED NOT NULL,
                Cholesterol   FLOAT UNSIGNED NOT NULL,
                Sodium   FLOAT UNSIGNED NOT NULL,
                Carbohydrate   FLOAT UNSIGNED NOT NULL,
                Fiber   FLOAT UNSIGNED NOT NULL,
                Sugar   FLOAT UNSIGNED NOT NULL,
                Protein   FLOAT UNSIGNED NOT NULL,
                FOREIGN KEY fk_RecipeId (RecipeId) REFERENCES recipes(Id), 
                PRIMARY KEY (RecipeId))
                """
    queries.append(nutrition_query)

    ingredients_query = \
        """
        CREATE TABLE IF NOT EXISTS ingredients (
                Id INT UNSIGNED NOT NULL,
                IngredientName varchar(100) NOT NULL,
                PRIMARY KEY (Id))
                """
    queries.append(ingredients_query)

    recipe_ingredients_query = \
        """
        CREATE TABLE IF NOT EXISTS recipe_ingredients (
                Id INT UNSIGNED AUTO_INCREMENT NOT NULL , 
                RecipeId MEDIUMINT UNSIGNED NOT NULL ,
                IngredientId INT UNSIGNED NOT NULL,
                Quantity  DECIMAL(16) UNSIGNED NOT NULL,
                CONSTRAINT fk_RecipeId FOREIGN KEY (RecipeId) REFERENCES recipes(Id), 
                CONSTRAINT fk_IngredientId FOREIGN KEY (IngredientId) REFERENCES ingredients(Id), 
                PRIMARY KEY (Id))
                """
    queries.append(recipe_ingredients_query)

    return queries


def create_record_insertion_queries():
    queries = {}
    users = "INSERT INTO users (Username, Password, Age, Sex, Height ,Weight) VALUES (%s, %s, %s, %s, %s, %s)"

    recipes = "INSERT INTO recipes (Id , RecipeName, CookTime, PrepTime, Images, RecipeCategory, RecipeInstructions)" \
        " VALUES (%s ,%s, %s, %s, %s, %s, %s)"
    queries['recipes'] = (recipes, 'data/recipes.csv')

    nutrition = "INSERT INTO nutrition (RecipeId, Calories, Fat, SaturatedFat, Cholesterol, Sodium, Carbohydrate," \
                " Fiber,Sugar, Protein) VALUES (%s ,%s, %s, %s, %s, %s, %s, %s, %s, %s)"
    queries['nutrition'] = (nutrition, 'data/nutrition.csv')

    ingredients = "INSERT INTO ingredients (Id, IngredientName) VALUES (%s, %s)"
    queries['ingredients'] = (ingredients, 'data/unique_ingredients.csv')

    recipe_ingredients = "INSERT INTO recipe_ingredients (RecipeId, IngredientId, Quantity) VALUES (%s, %s, %s)"
    queries['recipe_ingredients'] = (recipe_ingredients, 'data/ingredients_by_id.csv')

    return queries


def insert_records(db, cursor, queries):
    for k, (table, query) in enumerate(queries.items()):
        print()
        print('Inserting records to table: ' + table)
        table_path = query[1]
        table_query = query[0]

        for i, chunk in tqdm(enumerate(pd.read_csv(table_path, chunksize=1000))):
            records = chunk.where(pd.notnull(chunk), None).to_records(index=False).tolist()
            execute_query(db, cursor, table_query, True, records)


def create_recipes_db():
    db, cursor = connect_to_db(delete_if_exist=True)
    tables_queries = create_tables_queries()
    create_tables(db, cursor, tables_queries)

    queries = create_record_insertion_queries()
    insert_records(db, cursor, queries)

    disconnect(db, cursor)
