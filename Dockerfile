FROM openjdk:latest
RUN mkdir -p /app/home
WORKDIR /app/home
COPY ./target/myfirstspringbootapp-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "./myfirstspringbootapp-0.0.1-SNAPSHOT.jar" ]