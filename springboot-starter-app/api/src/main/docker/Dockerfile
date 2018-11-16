FROM maven as build
WORKDIR /app

RUN mkdir library api
COPY pom.xml .
COPY library/pom.xml ./library
COPY api/pom.xml ./api
COPY library .
RUN cd library && mvn install
COPY api .
RUN mvn package

FROM openjdk:8-jre
WORKDIR /app
COPY --from=build /app/target/springboot-starter-app-api-0.1.jar app.jar

CMD ["java","-jar","app.jar"]