import os
from flask import Flask
import psycopg2
import redis
import time

time.sleep(5)
connection = psycopg2.connect(
    host="postgres_test",
    user="postgres",
    port="5432",
    database="postgres")

cursor = connection.cursor()
cursor.execute("SELECT current_database()")
result_postgres = cursor.fetchall()

name = os.environ.get('REDIS_USER')

redis_hw = redis.Redis(host="redis_test", port=6379, db=0)
redis_hw.set('name', name)
result_redis = redis_hw.get('name')

app = Flask(__name__)
color = os.environ.get('APP_COLOR')

@app.route("/")
def main():
    return f'<html><body style="background:{color}"><h1><b>Postgres current database: {result_postgres}</b></h1><h1><b>Redis user name: {result_redis}</b></h1></body></html>';

if __name__ == '__main__':
      app.run(host='0.0.0.0', port=8080)

