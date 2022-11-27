# Java to Java Example

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

## Generate Code

```sh
protoc --java_out=./java-api-server/src/main/java --java_out=./java-grpc-server/src/main/java --proto_path=./proto message.proto && \
protoc --java_out=./java-api-server/src/main/java --java_out=./java-grpc-server/src/main/java --proto_path=./proto hello.proto
```

## docker-compose を使用しない場合

### MySQL の起動

```sh
docker run --name mysql -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=test -v "$(pwd)/mysql_ddl":/docker-entrypoint-initdb.d -it -d mysql:latest
```

### Run

```sh
cd java-api-server && \
./gradlew bootRun
```

```sh
cd java-grpc-server && \
./gradlew bootRun
```

## docker-compose を使用する場合

```sh
cd java-api-server && \
./gradlew bootBuildImage && \
cd .. && \
cd java-grpc-server && \
./gradlew bootBuildImage && \
cd .. && \
docker-compose build && \
docker-compose up -d mysql && \
docker-compose up -d backend && \
docker-compose up -d frontend
```
