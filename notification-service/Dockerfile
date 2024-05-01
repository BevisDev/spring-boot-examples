FROM maven:3.8.5-openjdk-17 as build

WORKDIR /build

COPY pom.xml ./

COPY . .

RUN mvn package -DskipTests

FROM openjdk:17-alpine as run

RUN apk update && apk add curl

COPY --from=build target/*.jar app.jar

CMD java -jar app.jar
