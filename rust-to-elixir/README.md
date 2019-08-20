# elixir-grpc-example

```$bash
brew install protobuf
```

```$bash
cargo install protobuf-codegen
cargo install grpcio-compiler
```

```$bash
cargo new rust-api-server
```

## Install elixir
https://elixir-lang.org/install.html

## create project
```$bash
mix new grpc_server
```

## Install protobuf-elixir
```$bash
mix escript.install hex protobuf
```

## Generate Code

```$bash
protoc --rust_out=./rust-api-server/src/ --grpc_out=./rust-api-server/src/ --plugin=protoc-gen-grpc=`which grpc_rust_plugin` --elixir_out=plugins=grpc:./grpc_server/lib --proto_path=./proto message.proto
protoc --rust_out=./rust-api-server/src/ --grpc_out=./rust-api-server/src/ --plugin=protoc-gen-grpc=`which grpc_rust_plugin` --elixir_out=plugins=grpc:./grpc_server/lib --proto_path=./proto hello.proto
```

## MySQL

```$bash
docker run --name mysql -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=test -it -d mysql:latest
```

## migrate
```$bash
mix deps.get
mix ecto.migrate
```

## Boot
```$bash
mix grpc.server
cd ../rust-api-server
cargo run
```

## docker-compose を使用する場合

```$bash
docker-compose build
docker-compose up -d
docker exec -it -e MIX_ENV=prod elixir-grpc-server mix ecto.migrate
```