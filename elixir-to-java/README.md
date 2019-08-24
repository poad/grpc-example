# elixir-grpc-example

## Install OpenJDK 11

### Install sdkman.io
```$bash
curl -s "https://get.sdkman.io" | bash
```

### Install OpenJDK
```$bash
sdk i java 11.0.4-zulu
```

### Install Apache Maven
```$bash
sdk i maven 3.6.1
```

## create Java project
```$bash
mvn archetype:generate -B \
        -DarchetypeGroupId=org.apache.maven.archetypes \
        -DarchetypeArtifactId=maven-archetype-quickstart \
        -DarchetypeVersion=1.1 \
        -DgroupId=com.github.poad.example \
        -DartifactId=java-grpc-elixir-server \
        -Dversion=1.0-SNAPSHOT \
        -Dpackage=com.github.poad.example.elixir.grpc
```

```$bash
brew install protobuf
```

## Install elixir
https://elixir-lang.org/install.html

## create project
```$bash
mix phx.new elixir_api_server --no-ecto --no-html --no-webpack
```

## Install protobuf-elixir
```$bash
mix escript.install hex protobuf
```

## Generate Code

```$bash
protoc --elixir_out=plugins=grpc:./elixir_api_server/lib --java_out=./java-grpc-server/src/main/java --proto_path=./proto message.proto
protoc --elixir_out=plugins=grpc:./elixir_api_server/lib --java_out=./java-grpc-server/src/main/java --proto_path=./proto hello.proto
```

## MySQL

```$bash
docker run --name mysql -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=test -it -d mysql:latest
```

## Boot
```$bash
cd java-grpc-elixir-server
mvn spring-boot:run
cd ../elixir_api_server
mix phx.server
```

## docker-compose を使用する場合

```$bash
cd java-grpc-elixir-server
mvn clean install jib:dockerBuild
cd ..
docker-compose build
docker-compose up -d
```