# grpc-example

```sh
brew update && \
brew upgrade
brew install protobuf
brew upgrade protobuf
```

```sh
cargo uninstall protobuf-codegen && \
cargo uninstall grpcio-compiler
cargo install protobuf-codegen && \
cargo install grpcio-compiler
```

```sh
protoc --rust_out=./rust-grpc-server/src/ --grpc_out=./rust-grpc-server/src/ --plugin=protoc-gen-grpc=$(which grpc_rust_plugin) --java_out=./java-grpc-example/src/main/java --proto_path=./rust-grpc-server/src/proto message.proto && \
protoc --rust_out=./rust-grpc-server/src/ --grpc_out=./rust-grpc-server/src/ --plugin=protoc-gen-grpc=$(which grpc_rust_plugin) --java_out=./java-grpc-example/src/main/java --proto_path=./rust-grpc-server/src/proto hello.proto
```

## Build and run by docker-compose

```sh
cd java-grpc-example && \
./gradlew bootBuildImage && \
cd .. && \
docker-compose build
```

```sh
docker-compose up -d postgres && \
docker-compose up -d backend && \
docker-compose up -d frontend
```
