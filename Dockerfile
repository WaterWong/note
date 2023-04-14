FROM openjdk:17-jdk-alpine
RUN mkdir -p /root/h2/data
VOLUME ["/root/h2/data"]
EXPOSE 6000
ARG JAR_FILE=dist/note-api-1.0.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} note-api.jar
ENTRYPOINT ["java","-Dfile.encoding=UTF-8", "-jar", "note-api.jar"]