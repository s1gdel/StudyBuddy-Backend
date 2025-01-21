# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Copy the .env file (if needed)
COPY .env .

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the application using Maven
RUN mvn clean package -DskipTests

# Expose the port that the application will run on
EXPOSE 8080

# Set the command to run the application
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]