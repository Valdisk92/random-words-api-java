FROM gradle:8-jdk-21-and-22-alpine as build

WORKDIR /app

COPY . .

RUN gradle clean build -x test

FROM amazoncorretto:21-alpine-jdk

RUN apk --no-cache add curl

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
