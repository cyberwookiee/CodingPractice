LABEL version="1.0"
LABEL description="Coding sample problems, that's all...."


FROM maven:3.8-jdk-8

RUN mkdir /project

ADD . /project

WORKDIR /project

CMD ["mvn", "package"]
