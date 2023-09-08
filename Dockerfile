FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 5001
ADD target/qrqc-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java","-jar","app.war"]