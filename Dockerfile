FROM maven:3.8-jdk-8

LABEL version="1.0"
LABEL description="Coding sample problems, that's all...."


RUN mkdir /project

ADD . /project

WORKDIR /project

CMD ["mvn", "package"]
