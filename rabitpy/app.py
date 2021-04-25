import pika
import time

#credentials = pika.PlainCredentials('guest', 'guest')
print('===================== hi hi hi')
time.sleep(10);
while True:
  try:
    print('===================== hi hi hi')
    #time.sleep(1);
    connection = pika.BlockingConnection(pika.ConnectionParameters('rabbit2'))
    channel = connection.channel()
    channel.queue_declare(queue='hello')

    channel.basic_publish(exchange='',
                          routing_key='hello',
                          body='Hello World!')
    print(" [x] Sent 'Hello World!'")
    connection.close()
  except Exception as e: 
    print("An exception occurred ", e)