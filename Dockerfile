# Primera etapa: Compilación de la aplicación con Maven
FROM maven:3.9.9-openjdk-17 AS build

# Define el directorio de trabajo
WORKDIR /app

# Copia el contenido del proyecto al contenedor
COPY . .

# Ejecuta el comando de Maven para compilar y empaquetar la aplicación, omitiendo las pruebas
RUN mvn clean package -DskipTests

# Segunda etapa: Ejecución de la aplicación en una imagen más liviana de OpenJDK
FROM openjdk:21-slim

# Define el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de la primera etapa al nuevo contenedor
COPY --from=build /app/target/JavaJenkins-0.0.1-SNAPSHOT.jar app.jar

# Comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]


