# ---- Build stage ----
FROM gradle:8.14.3-jdk17-alpine AS builder
WORKDIR /app

# Copy only Gradle config to cache dependencies
COPY build.gradle settings.gradle ./
# Now copy source and build actual jar
COPY src ./src
RUN gradle clean bootJar

# ---- Run stage ----
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
