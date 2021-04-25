FROM ubuntu

RUN apt-get update -y
RUN apt-get install -y python
RUN apt-get install -y python3-pip
RUN apt-get clean all
RUN pip3 install flask
RUN pip3 install psycopg2-binary
RUN pip3 install redis

EXPOSE 8080
COPY app.py /opt/app.py

ENTRYPOINT FLASK_APP=/opt/app.py flask run --host=0.0.0.0 --port=8080