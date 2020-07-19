FROM buildpack-deps:stable-curl AS download

WORKDIR /tmp

RUN curl -sSLo /tmp/llvm-snapshot.gpg.key https://apt.llvm.org/llvm-snapshot.gpg.key

FROM poad/docker-grpc:debian-buster AS build

WORKDIR /root

COPY src /root/rust-grpc-server/src
COPY Cargo.toml /root/rust-grpc-server/Cargo.toml
COPY diesel.toml /root/rust-grpc-server/diesel.toml

WORKDIR /root/rust-grpc-server/

RUN cargo build --release

FROM rust:slim

# ARG PROTOCOL_BUFFERS_VERSION

COPY --from=download /tmp/llvm-snapshot.gpg.key /tmp/llvm-snapshot.gpg.key

WORKDIR /tmp

RUN apt-get update -qq \
 && apt-get install --no-install-recommends -qqy ca-certificates gnupg2 binutils apt-utils \
 && cat /tmp/llvm-snapshot.gpg.key | apt-key add - \
 && echo "deb http://apt.llvm.org/buster/ llvm-toolchain-buster-10 main" >> /etc/apt/sources.list.d/llvm-toolchain.list \
 && apt-get update -qq \
 && apt-get install -qqy --no-install-recommends \
        clang-10 \
        lld-10 \
        libreadline-dev \
        libsqlite3-dev \
        libssl-dev \
        zlib1g-dev \
        libpq-dev \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/* /var/log/apt/* /var/log/alternatives.log /var/log/dpkg.log /var/log/faillog /var/log/lastlog \
 && rm -rf /tmp/*

COPY --from=build /root/rust-grpc-server/target/release/rust-grpc-server /root/rust-grpc-server/target/release/rust-grpc-server

WORKDIR /root

CMD ["/root/rust-grpc-server/target/release/rust-grpc-server"]
