FROM ubuntu
RUN apt-get update
RUN apt-get install -y python
RUN apt-get install -y python3-pip
RUN pip3 install pika
COPY app.py /opt/app.py
CMD ["/opt/app.py"]
ENTRYPOINT ["python3"]