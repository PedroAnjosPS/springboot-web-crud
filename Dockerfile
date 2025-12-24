# ========= ETAPA 1: BUILD =========
# Maven + Java 21 (imagem EXISTENTE e estável)
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# ========= ETAPA 2: RUNTIME =========
# Java 25 (LTS, runtime apenas)
FROM eclipse-temurin:25-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
