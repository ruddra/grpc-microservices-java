FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
CMD ["java", "-jar", "/app/app.jar"]