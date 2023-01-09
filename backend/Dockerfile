FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /home/spring/app
ARG JAR_FILE=build/libs/devnet-1.0.0.jar
COPY ${JAR_FILE} devnet-backend.jar
ENTRYPOINT [ "java" ]
CMD [ "-jar", "devnet-backend.jar", "--spring.profiles.active=prod" ]
EXPOSE 8080