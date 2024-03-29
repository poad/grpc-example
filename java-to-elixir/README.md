# elixir-grpc-example

## Install OpenJDK 11

### Install sdkman.io

```sh
curl -s "https://get.sdkman.io" | sh
```

### Install OpenJDK

```sh
sdk i java 17.0.5.fx-librca
```

### Install Gradle

```sh
sdk i gradle 7.6
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
protoc --elixir_out=plugins=grpc:./grpc_server/lib --java_out=./elixir-grpc-java/src/main/java --proto_path=./proto message.proto && \
protoc --elixir_out=plugins=grpc:./grpc_server/lib --java_out=./elixir-grpc-java/src/main/java --proto_path=./proto hello.proto
```

## Run

### docker-compose を使用しない場合

#### MySQL

```sh
docker run --name mysql -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=test -it -d mysql:latest
```

#### migrate

```sh
cd grpc_server && \
mix deps.get && \
mix ecto.migrate && \
cd ..
```

#### Boot

```sh
cd grpc_server && \
mix grpc.server
```

```sh
cd elixir-grpc-java && \
./gradlew bootRun
```

### docker-compose を使用する場合

```sh
cd elixir-grpc-java && \
./gradlew bootBuildImage && \
cd .. && \
docker-compose build && \
docker-compose up -d mysql && \
docker exec -it -e MIX_ENV=prod elixir-grpc-server mix ecto.migrate && \
docker-compose up -d backend && \
docker-compose up -d frontend
```

## その他

mix を使ったパッケージのアップデート

```sh
cd grpc_server && \
mix deps.update --all mix.ex
```
