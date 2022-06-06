FROM poad/docker-grpc:debian-buster AS build

WORKDIR /root

COPY src /root/rust-api-server/src
COPY Cargo.toml /root/rust-api-server/Cargo.toml
COPY build.rs /root/rust-api-server/build.rs

WORKDIR /root/rust-api-server/

RUN cargo build --release

FROM rust:slim


COPY --from=build /root/rust-api-server/target/release/rust-api-server /root/rust-api-server/target/release/rust-api-server

WORKDIR /root

CMD ["/root/rust-api-server/target/release/rust-api-server"]
