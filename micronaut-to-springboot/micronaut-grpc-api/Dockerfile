FROM oracle/graalvm-ce:19.2.0.1 as graalvm

RUN gu install native-image
COPY micronaut-grpc-api /home/app/micronaut-grpc-api
COPY proto /home/app/proto
WORKDIR /home/app/micronaut-grpc-api
RUN ./mvnw package
RUN native-image --no-server \
                 --allow-incomplete-classpath \
                 -H:+ReportExceptionStackTraces \
                 -H:+TraceClassInitialization \
                 --initialize-at-run-time=io.netty.handler.codec.http2.Http2CodecUtil \
                 -cp target/micronaut-grpc-api-0.1.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-grpc-api .
ENTRYPOINT ["./micronaut-grpc-api"]
