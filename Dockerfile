FROM openjdk:17-oracle

VOLUME /tmp

EXPOSE 8000

ADD /target/AutorizationService-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]