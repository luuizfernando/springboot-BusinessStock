FROM openjdk:21

WORKDIR /app

COPY target/businesstock-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "businesstock-0.0.1-SNAPSHOT.jar" ]