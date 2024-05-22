FROM openjdk:17
WORKDIR /app
COPY . /app
CMD ["java", "-jar", "target/esoft-demo-0.0.1-SNAPSHOT.jar"]