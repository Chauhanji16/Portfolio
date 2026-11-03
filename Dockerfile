
# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-25 AS build

# Set the working directory
WORKDIR /app

# Copy Maven configuration
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy application source code
COPY src ./src

# Build the application JAR
RUN mvn clean package -DskipTests 


# Stage 2: Run the application
FROM eclipse-temurin:25-jre

# Set the working directory
WORKDIR /app

# Copy the generated JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080



# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
