# elixir-grpc-example

```sh
brew install protobuf
```

## Install OpenJDK 11

### Install sdkman.io

```sh
curl -s "https://get.sdkman.io" | sh
```

### Install OpenJDK

```sh
sdk i java 11.0.12-zulu
```

### Install Gradle

```sh
sdk i gradle 7.2
```

## Install elixir

<https://elixir-lang.org/install.html>

## create project

```sh
mix phx.new elixir_api_server --no-ecto --no-html --no-webpack
```

## Install protobuf-elixir

```sh
mix escript.install hex protobuf
```

## Generate Code

```sh
protoc --elixir_out=plugins=grpc:./elixir_api_server/lib --java_out=./java-grpc-elixir-server/src/main/java --proto_path=./proto message.proto && \
protoc --elixir_out=plugins=grpc:./elixir_api_server/lib --java_out=./java-grpc-elixir-server/src/main/java --proto_path=./proto hello.proto
```

## MySQL

```sh
docker run --name mysql -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=test -it -d mysql:latest
```

## Run

### docker-compose を使用しない場合

```sh
cd java-grpc-elixir-server && \
./gradlew bootRun
```

```sh
cd elixir_api_server && \
mix phx.server
```

### docker-compose を使用する場合

```sh
cd java-grpc-elixir-server && \
./gradlew bootBuildImage && \
cd .. && \
docker-compose build && \
docker-compose up -d mysql && \
docker-compose up -d backend && \
docker-compose up -d frontend
```
