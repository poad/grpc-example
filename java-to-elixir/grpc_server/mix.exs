defmodule GrpcServer.MixProject do
  use Mix.Project

  def project do
    [
      app: :grpc_server,
      version: "0.1.0",
      elixir: "~> 1.9",
      start_permanent: Mix.env() == :dev,
      deps: deps()
    ]
  end

  # Run "mix help compile.app" to learn about applications.
  def application do
    [
      mod: {GrpcServer, []},
      extra_applications: [:grpc, :logger],
    ]
  end

  # Run "mix help deps" to learn about dependencies.
  defp deps do
    [
      {:grpc, github: "elixir-grpc/grpc"},
      {:protobuf, github: "tony612/protobuf-elixir", override: true},
      {:ecto_sql, ">= 3.1.6"},
      {:myxql, ">= 0.2.6"},
      {:ex_doc, "~> 0.19", only: :dev, runtime: false},
      {:dialyxir, "~> 0.5", only: [:dev, :test], runtime: false},
    ]
  end
end
