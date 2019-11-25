sdk i java 19.3.0-grl
gu install native-image
./mvnw package
native-image --no-server \
             -H:+TraceClassInitialization \
             --no-fallback  \
             -cp target/micronaut-grpc-api-0.1.jar
