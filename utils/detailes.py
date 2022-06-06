import json


def get_username_password():
    '''
    example for credentials.json (place in main folder):
    (change password)
        {
            "username": "root",
            "password": "my_password"
        }
    '''
    f = open('credentials.json')
    details = json.load(f)
    f.close()
    return details
