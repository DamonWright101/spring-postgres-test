FROM maven as build
WORKDIR /app

RUN mkdir library web
COPY pom.xml .
COPY library/pom.xml ./library
COPY web/pom.xml ./web
COPY library .
RUN cd library && mvn install
COPY web .
RUN mvn package

FROM openjdk:8-jre
WORKDIR /app
COPY --from=build /app/target/springboot-starter-app-web-0.1.jar app.jar

CMD ["java","-jar","app.jar"]