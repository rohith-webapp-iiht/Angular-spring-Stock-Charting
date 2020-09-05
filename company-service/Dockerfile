FROM openjdk:latest
EXPOSE 8080
ADD target/hello-world.jar hello-world.jar
ENTRYPOINT ["sh", "-c", "java -jar /hello-world.jar"]