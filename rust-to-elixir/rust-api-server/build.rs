extern crate protoc_grpcio;

fn main() {
    let proto_root = "src";
    println!("cargo:rerun-if-changed={}", proto_root);
    protoc_grpcio::compile_grpc_protos(
        &["proto/hello.proto", "proto/message.proto"],
        &[proto_root],
        &proto_root,
        None
    ).expect("Failed to compile gRPC definitions!");
}
