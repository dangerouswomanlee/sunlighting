FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . .
RUN ./mvnw -B -DskipTests package
EXPOSE 10000
CMD ["java", "-jar", "target/site-0.0.1-SNAPSHOT.jar"]
