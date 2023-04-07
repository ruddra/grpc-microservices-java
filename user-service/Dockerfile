
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY ./user-service/target/user-service-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]