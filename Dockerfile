FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . .
RUN ./mvnw -B -DskipTests package
RUN addgroup -S app && adduser -S app -G app
USER app
EXPOSE 10000
CMD ["java", "-jar", "target/site-0.0.1-SNAPSHOT.jar"]
