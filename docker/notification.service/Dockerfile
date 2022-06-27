FROM maven:3.6.0-jdk-8-slim AS build_sender
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml package

FROM openjdk:8
ARG JAR_FILE=/home/app/target/*.jar
COPY --from=build_sender ${JAR_FILE} notification-service.jar
ENTRYPOINT ["java","-jar","/notification-service.jar"]