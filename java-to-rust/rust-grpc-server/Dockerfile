FROM rust:latest

RUN apt update -qq \
 && apt full-upgrade -qqy \
 && apt install -qqy --no-install-recommends \
         autoconf \
         automake \
         libtool \
         curl \
         make \
         g++ \
         unzip \
         git \
         cmake \
         golang

RUN git clone https://github.com/google/protobuf.git \
 && cd protobuf \
 && git checkout v3.8.0 \
 && git submodule update --init --recursive \
 && ./autogen.sh \
 && ./configure --prefix=/usr \
 && make \
 && make check \
 && make install \
 && ldconfig

COPY src /root/rust-grpc-server/src
COPY Cargo.lock /root/rust-grpc-server/Cargo.lock
COPY Cargo.toml /root/rust-grpc-server/Cargo.toml
COPY diesel.toml /root/rust-grpc-server/diesel.toml
#COPY .env /root/rust-grpc-server/.env

WORKDIR /root/rust-grpc-server/

RUN cargo build --release

CMD ["/root/rust-grpc-server/target/release/rust-grpc-server"]