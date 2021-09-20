ARG LLVM_VERSION=12

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

ARG LLVM_VERSION
# ARG PROTOCOL_BUFFERS_VERSION

COPY --from=download /tmp/llvm-snapshot.gpg.key /tmp/llvm-snapshot.gpg.key

WORKDIR /tmp

RUN apt-get update -qq \
 && apt-get install --no-install-recommends -qqy lsb-release ca-certificates gnupg2 binutils apt-utils \
 && cat /tmp/llvm-snapshot.gpg.key | gpg --no-default-keyring --keyring "gnupg-ring:/usr/share/keyrings/llvm-snapshot.gpg" --import - \
 && chmod 644 /usr/share/keyrings/llvm-snapshot.gpg \
 && echo "deb [arch=amd64 signed-by=/usr/share/keyrings/llvm-snapshot.gpg] http://apt.llvm.org/$(lsb_release -cs)/ llvm-toolchain-$(lsb_release -cs)-${LLVM_VERSION} main" > /etc/apt/sources.list.d/llvm-toolchain.list \
 && apt-get update -qq \
 && apt-get install -qqy --no-install-recommends \
        libtool \
        clang-${LLVM_VERSION} \
        lld-${LLVM_VERSION} \
        libreadline-dev \
        libsqlite3-dev \
        libssl-dev \
        unzip \
        zlib1g-dev \
        pkg-config \
        unzip \
        cmake \
        libpq-dev \
        libodbc1 \
        libssl1.1 \
        libsctp1 \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/* /var/log/apt/* /var/log/alternatives.log /var/log/dpkg.log /var/log/faillog /var/log/lastlog \
 && rm -rf /tmp/*

COPY --from=build /root/rust-grpc-server/target/release/rust-grpc-server /root/rust-grpc-server/target/release/rust-grpc-server

WORKDIR /root

CMD ["/root/rust-grpc-server/target/release/rust-grpc-server"]
