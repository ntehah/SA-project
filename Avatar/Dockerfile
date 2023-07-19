FROM openjdk:17-jdk-slim as builder

WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn

RUN chmod +x ./mvnw

COPY pom.xml .

COPY src src
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:17-jdk-slim

ARG DEPENDENCY=/workspace/app/target/dependency

COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.SA.Avatar.AvatarApplication"]