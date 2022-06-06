fn main() {
    let proto_files = &["src/proto/hello.proto", "src/proto/message.proto"];
    tonic_build::configure()
        .build_server(true)
        .build_client(false)
        .out_dir("src")
        .compile(proto_files, &["src/proto"])
        .unwrap_or_else(|e| panic!("protobuf compile error: {}", e));
}
