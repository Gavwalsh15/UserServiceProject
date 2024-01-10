FROM eclipse-temurin:17-alpine

WORKDIR /app

COPY target/UserServiceProject-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "UserServiceProject-0.0.1-SNAPSHOT.jar", "spring.profiles.active=docker"]

