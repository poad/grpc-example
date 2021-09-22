# elixir-grpc-example

```sh
brew install protobuf
```

```sh
cargo install protobuf-codegen
cargo install grpcio-compiler
```

```sh
cargo new rust-api-server
```

## Install elixir

<https://elixir-lang.org/install.html>

## create project

```sh
mix new grpc_server
```

## Install protobuf-elixir

```sh
mix escript.install hex protobuf
```

## Generate Code

```sh
protoc --rust_out=./rust-api-server/src/ --grpc_out=./rust-api-server/src/ --plugin=protoc-gen-grpc=`which grpc_rust_plugin` --elixir_out=plugins=grpc:./grpc_server/lib --proto_path=./proto message.proto && \
protoc --rust_out=./rust-api-server/src/ --grpc_out=./rust-api-server/src/ --plugin=protoc-gen-grpc=`which grpc_rust_plugin` --elixir_out=plugins=grpc:./grpc_server/lib --proto_path=./proto hello.proto
```

## docker-compose を使用しない場合

### MySQL

```sh
docker run --name mysql -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=test -it -d mysql:latest
```

### migrate

```sh
cd grpc_server && \
mix deps.get && \
mix deps.update --all && \
mix ecto.migrate && \
cd ..
```

### Boot

```sh
cd grpc_server && \
mix grpc.server
```

```sh
cd rust-api-server
cargo run
```

## docker-compose を使用する場合

```sh
docker-compose build && \
docker-compose up -d mysql && \
docker exec -it -e MIX_ENV=prod elixir-grpc-server mix ecto.migrate && \
docker-compose up -d backend && \
docker-compose up -d frontend
```
