# Java to Java Example

## Install OpenJDK 11

### Install sdkman.io

```sh
curl -s "https://get.sdkman.io" | bash
```

### Install OpenJDK

```sh
sdk i java 11.0.13.fx-librca
```

### Install Gradle

```sh
sdk i gradle 7.3.1
```

## Generate Code

```sh
protoc --java_out=./micronaut-grpc-api/src/main/java --java_out=./java-micronaut-grpc-server/src/main/java --proto_path=./proto message.proto && \
protoc --java_out=./micronaut-grpc-api/src/main/java --java_out=./java-micronaut-grpc-server/src/main/java --proto_path=./proto hello.proto
```

## MySQL

```sh
docker run --name mysql -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=test -v "$(pwd)/mysql_ddl":/docker-entrypoint-initdb.d -it -d mysql:latest
```

## docker-compose を使用する場合

```sh
cd java-micronaut-grpc-server && \
./gradlew bootBuildImage && \
cd ..
docker-compose build && \
docker-compose up -d mysql && \
docker-compose up -d backend && \
docker-compose up -d frontend
```
