FROM openjdk:21-jdk-slim
RUN mkdir -p /root/h2/data
VOLUME ["/root/h2/data"]
EXPOSE 6060
ARG JAR_FILE=./note-api/target/note-api-1.2.0-SNAPSHOT.jar
ADD ${JAR_FILE} note-api.jar
ENTRYPOINT ["java","-Dfile.encoding=UTF-8", "-jar", "note-api.jar"]