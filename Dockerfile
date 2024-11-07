FROM alpine/java:21-jdk

EXPOSE 8080
VOLUME ["/opt/spaceships"]

RUN addgroup -S spring && adduser -S spring -G spring

USER spring
COPY w2m-ms-spaceships-api-boot/target/w2m-ms-spaceships-api-boot*.jar /opt/spaceships/app.jar

CMD ["java", "-jar", "/opt/spaceships/app.jar"]
