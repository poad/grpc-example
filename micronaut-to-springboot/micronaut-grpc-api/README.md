# How to build

sdk i java 20.1.0.r11-grl
gu install native-image
./mvnw package
native-image --no-server \
             -H:+TraceClassInitialization \
             --no-fallback  \
             -cp target/micronaut-grpc-api-0.1.jar
