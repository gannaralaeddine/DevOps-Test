FROM openjdk:8-jdk-alpine

COPY ./target/DevopsTest-1.0.jar /usr/app/

WORKDIR /usr/app

EXPOSE 8089

RUN sh -c 'touch demo-docker-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","DevopsTest-1.0.jar"]
