FROM openjdk:17.0.2

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn ./.mvn

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "./target/pregunta-service-0.0.1-SNAPSHOT.jar"]