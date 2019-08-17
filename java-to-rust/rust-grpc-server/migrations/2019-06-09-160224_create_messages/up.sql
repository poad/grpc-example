-- Your SQL goes here
\c grpc_rust

CREATE TABLE message (
  id TEXT PRIMARY KEY,
  content TEXT NOT NULL
)