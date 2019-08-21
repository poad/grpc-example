use Mix.Config

config :grpc_server, Message.Repo,
       url: "mysql://root@127.0.0.1:3306/test"

config :grpc_server, UUIDGen.Repo,
       url: "mysql://root@127.0.0.1:3306/test"

config :grpc_server, ecto_repos: [Message.Repo, UUIDGen.Repo]

config :logger, :console,
       level: :info,
       backends: [:console],
               compile_time_purge_level: :debug