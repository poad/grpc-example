# grpc-example

```$
brew install protobuf
```

```$
cargo install protobuf-codegen
cargo install grpcio-compiler
```

```$
protoc --rust_out=./rust-grpc-server/src/ --grpc_out=./rust-grpc-server/src/ --plugin=protoc-gen-grpc=`which grpc_rust_plugin` --java_out=./java-grpc-example/src/main/java --proto_path=./proto message.proto
protoc --rust_out=./rust-grpc-server/src/ --grpc_out=./rust-grpc-server/src/ --plugin=protoc-gen-grpc=`which grpc_rust_plugin` --java_out=./java-grpc-example/src/main/java --proto_path=./proto hello.proto
```

```$
cd java-grpc-example
./mvnw compile jib:build
cd ..
docker-compose build
```


```$
docker-compose up -d
```

