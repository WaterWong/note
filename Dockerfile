#FROM maven:3.8.7-openjdk-18-slim
#COPY note-api /home/app/note-api
#COPY pom.xml /home/app/pom.xml
#COPY ./bin/maven/conf/settings.xml /usr/share/maven/conf/settings.xml
#RUN mkdir -p /maven/.m2
#RUN mkdir -p /maven/dist
#VOLUME ["/maven/.m2","maven/dist"]
#RUN ls -l /maven/.m2
#RUN mvn -f /home/app/pom.xml clean package
#RUN cp /home/app/target/note-api-1.0.0.0-SNAPSHOT.jar /maven/dist

FROM openjdk:17-jdk-alpine
RUN mkdir -p /root/h2/data
VOLUME ["/root/h2/data"]
EXPOSE 8000
ARG JAR_FILE=dist/note-api-1.0.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} note-api.jar
ENTRYPOINT ["java","-Dfile.encoding=UTF-8", "-jar", "note-api.jar"]