FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar MemberServices-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/MemberServices-0.0.1-SNAPSHOT.jar"]