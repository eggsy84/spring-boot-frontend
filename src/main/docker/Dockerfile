FROM java:openjdk-8u66-jdk

MAINTAINER eggsy@eggsylife.co.uk
VOLUME /tmp
ADD web-frontend-0.1.0.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]