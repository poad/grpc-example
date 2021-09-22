FROM mcr.microsoft.com/java/jdk:11-zulu-ubuntu AS build

COPY micronaut-grpc-api /root/micronaut-grpc-api
COPY proto /root/proto
WORKDIR /root/micronaut-grpc-api
RUN mkdir -p /tmp/condig
RUN ./gradlew clean jar

FROM mcr.microsoft.com/java/jre-headless:11-zulu-alpine
EXPOSE 8080

RUN mkdir -p /app
WORKDIR /app
COPY --from=build /root/micronaut-grpc-api/build/libs/micronaut-grpc-api-0.1.jar .
COPY --from=build /tmp/condig .
ENTRYPOINT ["java", "-jar", "micronaut-grpc-api-0.1.jar"]
