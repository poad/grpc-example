#!/bin/sh
cd ..
docker build --rm -m 6g . -f micronaut-grpc-api/Dockerfile -t micronaut-grpc-api && \
echo && \
echo && \
echo "To run the docker container execute:" && \
echo "    $ docker run -p 8080:8080 micronaut-grpc-api"
