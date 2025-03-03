# Usar una imagen base de Java
FROM openjdk:17-jdk-alpine

# Copiar el archivo JAR de la aplicación
COPY target/review-service.jar review-service.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "review-service.jar"]