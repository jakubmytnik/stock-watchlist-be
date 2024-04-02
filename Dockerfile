FROM openjdk:21-slim-bullseye
ADD target/@project.build.finalName@.jar @project.build.finalName@.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:9999",  "/@project.build.finalName@.jar"]
