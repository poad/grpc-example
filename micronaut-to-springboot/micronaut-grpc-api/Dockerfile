FROM oracle/graalvm-ce:1.0.0-rc15 as graalvm
COPY . /home/app/micronaut-grpc-api
WORKDIR /home/app/micronaut-grpc-api
RUN native-image --no-server -cp target/micronaut-grpc-api-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-grpc-api .
ENTRYPOINT ["./micronaut-grpc-api"]
