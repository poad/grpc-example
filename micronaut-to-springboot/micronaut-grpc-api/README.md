# How to build

sdk i java 21.2.0.r11-grl
gu install native-image
./gradlew jar
native-image --no-server \
             -H:+TraceClassInitialization \
             --no-fallback  \
             -cp target/micronaut-grpc-api-0.1.jar
