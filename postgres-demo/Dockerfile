FROM maven as build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn package

FROM openjdk:8-jre
WORKDIR /app
COPY --from=build /app/target/app.jar .

CMD ["java","-jar","app.jar"]