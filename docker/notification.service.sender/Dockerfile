FROM maven:3.6.0-jdk-8-slim AS build_sender
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml package

FROM openjdk:8-jre-slim
COPY --from=build_sender /home/app/target/notification-service-sender-1.0-SNAPSHOT.jar /usr/local/lib/notification-service-sender-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/notification-service-sender-1.0-SNAPSHOT.jar"]