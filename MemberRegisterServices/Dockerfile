FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar MemberRegisterServices-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/MemberRegisterServices-0.0.1-SNAPSHOT.jar"]