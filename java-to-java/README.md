# Java to Java Example

## Install OpenJDK 11

### Install sdkman.io

```$sh
curl -s "https://get.sdkman.io" | sh
```

### Install OpenJDK

```$sh
sdk i java 11.0.5-zulu
```

### Install Apache Maven

```$sh
sdk i maven 3.6.3
```

## create Java project

```$sh
mvn archetype:generate -B \
        -DarchetypeGroupId=org.apache.maven.archetypes \
        -DarchetypeArtifactId=maven-archetype-quickstart \
        -DarchetypeVersion=1.1 \
        -DgroupId=com.github.poad.example \
        -DartifactId=java-api-server \
        -Dversion=1.0-SNAPSHOT \
        -Dpackage=com.github.poad.example.elixir.grpc

mvn archetype:generate -B \
        -DarchetypeGroupId=org.apache.maven.archetypes \
        -DarchetypeArtifactId=maven-archetype-quickstart \
        -DarchetypeVersion=1.1 \
        -DgroupId=com.github.poad.example \
        -DartifactId=java-grpc-server \
        -Dversion=1.0-SNAPSHOT \
        -Dpackage=com.github.poad.example.elixir.grpc
```

## Generate Code

```$sh
protoc --java_out=./java-api-server/src/main/java --java_out=./java-grpc-server/src/main/java --proto_path=./proto message.proto
protoc --java_out=./java-api-server/src/main/java --java_out=./java-grpc-server/src/main/java --proto_path=./proto hello.proto
```

## docker-compose を使用しない場合

### MySQL の起動

```$sh
docker run --name mysql -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=test -v "$(pwd)/mysql_ddl":/docker-entrypoint-initdb.d -it -d mysql:latest
```

### Run

```$sh
cd java-api-server && \
mvn spring-boot:run
```

```$sh
cd java-grpc-server && \
mvn spring-boot:run
```

## docker-compose を使用する場合

```$sh
cd java-api-server && \
mvn clean install spring-boot:build-image && \
cd .. && \
cd java-grpc-server && \
mvn clean install spring-boot:build-image && \
cd .. && \
docker-compose build && \
docker-compose up -d mysql && \
docker-compose up -d backend && \
docker-compose up -d frontend
```
