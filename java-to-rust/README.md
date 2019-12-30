# grpc-example

```$
brew update && \
brew upgrade
brew install protobuf
brew upgrade protobuf
```

```$
cargo uninstall protobuf-codegen && \
cargo uninstall grpcio-compiler
cargo install protobuf-codegen && \
cargo install grpcio-compiler
```

```$
protoc --rust_out=./rust-grpc-server/src/ --grpc_out=./rust-grpc-server/src/ --plugin=protoc-gen-grpc=`which grpc_rust_plugin` --java_out=./ java-grpc-example/src/main/java --proto_path=./proto message.proto && \
protoc --rust_out=./rust-grpc-server/src/ --grpc_out=./rust-grpc-server/src/ --plugin=protoc-gen-grpc=`which grpc_rust_plugin` --java_out=./java-grpc-example/src/main/java --proto_path=./proto hello.proto
```

## Build and run by docker-compose

```$
cd java-grpc-example && \
./mvnw jib:dockerBuild && \
cd .. && \
docker-compose build
```

```$
docker-compose up -d postgres && \
docker-compose up -d backend && \
docker-compose up -d frontend
```
