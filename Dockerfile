FROM maven:3.8.4-openjdk-11-slim AS build
COPY src /home/api/src
COPY pom.xml /home/api
RUN mvn -f /home/api/pom.xml clean package -DskipTests
FROM openjdk:11.0.2-jdk-slim
COPY --from=build /home/api/target/*.jar /usr/local/lib/api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/api.jar"]