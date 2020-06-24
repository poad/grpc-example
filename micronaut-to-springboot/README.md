# Java to Java Example

## Install OpenJDK 11

### Install sdkman.io

```$bash
curl -s "https://get.sdkman.io" | bash
```

### Install OpenJDK

```$bash
sdk i java 11.0.5-zulu
```

### Install Apache Maven

```$bash
sdk i maven 3.6.3
```

## create Java project

```$bash
mn create-app micronaut-grpc-api --features graal-native-image --build maven

mvn archetype:generate -B \
        -DarchetypeGroupId=org.apache.maven.archetypes \
        -DarchetypeArtifactId=maven-archetype-quickstart \
        -DarchetypeVersion=1.1 \
        -DgroupId=com.github.poad.example \
        -DartifactId=java-micronaut-grpc-server \
        -Dversion=1.0-SNAPSHOT \
        -Dpackage=com.github.poad.example.micronaut.grpc
```

## Generate Code

```$bash
protoc --java_out=./micronaut-grpc-api/src/main/java --java_out=./java-micronaut-grpc-server/src/main/java --proto_path=./proto message.proto
protoc --java_out=./micronaut-grpc-api/src/main/java --java_out=./java-micronaut-grpc-server/src/main/java --proto_path=./proto hello.proto
```

## MySQL

```$bash
docker run --name mysql -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=test -v "$(pwd)/mysql_ddl":/docker-entrypoint-initdb.d -it -d mysql:latest
```

## docker-compose を使用する場合

```$bash
cd java-micronaut-grpc-server && \
mvn clean install spring-boot:build-image && \
cd ..
docker-compose build && \
docker-compose up -d mysql && \
docker-compose up -d backend && \
docker-compose up -d frontend
```
