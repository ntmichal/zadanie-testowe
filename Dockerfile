FROM maven:3.8.1-jdk-11-slim AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/

RUN mvn package

FROM openjdk:11-jre-slim

COPY --from=MAVEN_BUILD /build/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8080