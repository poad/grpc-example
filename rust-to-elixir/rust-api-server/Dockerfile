FROM buildpack-deps:stable-curl AS download

WORKDIR /tmp

RUN curl -sSLo /tmp/llvm-snapshot.gpg.key https://apt.llvm.org/llvm-snapshot.gpg.key

FROM poad/docker-grpc:debian-buster AS build

WORKDIR /root

COPY src /root/rust-api-server/src
COPY Cargo.toml /root/rust-api-server/Cargo.toml

WORKDIR /root/rust-api-server/

RUN cargo build --release

FROM rust:slim


COPY --from=build /root/rust-api-server/target/release/rust-api-server /root/rust-api-server/target/release/rust-api-server

WORKDIR /root

CMD ["/root/rust-api-server/target/release/rust-api-server"]
