FROM openjdk:8-jre-alpine

ADD *.jar /app.jar

EXPOSE 8080

CMD java ${JAVA_OPTS} -jar /app.jar ${SPRING_CMD_PARAMS}