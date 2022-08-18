# base docker image
# Java 11
FROM openjdk:11
LABEL maintainer="rkguo.xyz"

ADD target/Student-Management-System-0.0.1-SNAPSHOT.jar student-management-docker.jar

ENTRYPOINT ["java", "-jar", "student-management-docker.jar"]