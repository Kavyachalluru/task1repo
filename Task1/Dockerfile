FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the target directory
COPY target/Task1-0.0.1-SNAPSHOT.jar task1.jar

# Expose the application port
EXPOSE 8081

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "task1.jar"]
