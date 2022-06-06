from flask import Flask, request, render_template, jsonify

from db.db_connection import yield_query_result, execute_query
from server.queries import check_user, insert_user, search_recipe, update_recipe
from server.sql_connection import SQLConnection


app = Flask(__name__)
connection = SQLConnection()


@app.route('/users/', methods=['GET', 'POST'])
def users():
    if request.method == 'GET':
        request_as_dict = request.get_json(force=True)
        db, cursor = connection.get()
        return jsonify({"response": yield_query_result(db, cursor, check_user(**request_as_dict))})

    if request.method == 'POST':
        request_as_dict = request.get_json(force=True)
        db, cursor = connection.get()
        return jsonify({"response": execute_query(db, cursor, insert_user(**request_as_dict))})


@app.route('/recipes/', methods=['GET', 'POST'])
def recipes():
    if request.method == 'GET':
        request_as_dict = request.get_json(force=True)
        db, cursor = connection.get()
        return jsonify({"response": yield_query_result(db, cursor, search_recipe(**request_as_dict))})

    if request.method == 'POST':
        request_as_dict = request.get_json(force=True)
        db, cursor = connection.get()
        return jsonify({"response": execute_query(db, cursor, update_recipe(**request_as_dict))})

# default port 5000
# default ip 127.0.0.1
def start_server():
    app.run(host="localhost", port=8000,debug=True)
    connection.start()
    


def stop_server():
    connection.stop()


# if __name__ == '__main__':
#     connection.start()
#     app.run(debug=True)
#     connection.stop()
