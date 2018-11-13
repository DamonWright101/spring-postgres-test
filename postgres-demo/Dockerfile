FROM maven as build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn package

FROM openjdk:8-jre
WORKDIR /app

COPY --from=build /app/target/app.jar .
COPY src/main/docker/start.sh start.sh
COPY src/main/docker/wait-for-it.sh wait-for-it.sh
RUN chmod +x ./*

CMD ["./start.sh"]