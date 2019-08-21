FROM rust:slim

RUN apt update -qq \
 && apt full-upgrade -qqy \
 && apt install -qqy --no-install-recommends \
         autoconf \
         automake \
         libtool \
         curl \
         make \
         pkg-config \
         g++ \
         unzip \
         git \
         cmake \
         golang \
         libssl-dev

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

COPY src /root/rust-api-server/src
COPY Cargo.lock /root/rust-api-server/Cargo.lock
COPY Cargo.toml /root/rust-api-server/Cargo.toml
#COPY .env /root/rust-api-server/.env

WORKDIR /root/rust-api-server/

RUN cargo build --release

CMD ["/root/rust-api-server/target/release/rust-api-server"]