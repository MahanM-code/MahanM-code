FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

# Copy everything first
COPY . .

# Default command: run tests when container starts
CMD ["mvn", "test"]
