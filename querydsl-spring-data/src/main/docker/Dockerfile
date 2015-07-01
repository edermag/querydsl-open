FROM edermag/ubuntu-java-8-dev

VOLUME /tmp
ADD querydsl-spring-data.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

