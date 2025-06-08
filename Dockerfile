# Use Java 21 as the base image
FROM eclipse-temurin:21-jdk AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle files
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Make the Gradle wrapper executable
RUN chmod +x ./gradlew

# Copy the source code
COPY src src

# Build the application
RUN ./gradlew build -x test

# Create a lightweight runtime image
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8000

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]