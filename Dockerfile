FROM openjdk:21-jdk

COPY target/Tondeuse-0.0.1-SNAPSHOT.jar   tondeuse.jar

ENTRYPOINT ["java","-jar","/tondeuse.jar"]