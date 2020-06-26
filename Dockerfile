FROM openjdk:8
MAINTAINER Pavan K S

COPY . /usr/src/app/
WORKDIR /usr/src/app/
RUN ./gradlew clean build
RUN mv build/libs/TruckerProducer-0.0.1-SNAPSHOT.jar TruckerProducer.jar

ENTRYPOINT java -jar TruckerProducer.jar