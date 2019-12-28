use Mix.Config

config :grpc_server, Message.Repo,
       url: "mysql://root@mysql:3306/test"

config :grpc_server, UUIDGen.Repo,
       url: "mysql://root@mysql:3306/test"

config :grpc_server, ecto_repos: [Message.Repo, UUIDGen.Repo]

config :grpc, start_server: true

config :logger, :console,
       level: :warn,
       backends: [:console],
              compile_time_purge_level: :info