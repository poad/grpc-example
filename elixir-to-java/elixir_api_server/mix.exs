defmodule ElixirApiServer.MixProject do
  use Mix.Project

  def project do
    [
      app: :elixir_api_server,
      version: "0.1.0",
      elixir: "~> 1.5",
      elixirc_paths: elixirc_paths(Mix.env()),
      compilers: [:phoenix, :gettext] ++ Mix.compilers(),
      start_permanent: Mix.env() == :prod,
      deps: deps()
    ]
  end

  # Configuration for the OTP application.
  #
  # Type `mix help compile.app` for more information.
  def application do
    [
      mod: {ElixirApiServer.Application, []},
      extra_applications: [:logger, :runtime_tools]
    ]
  end

  # Specifies which paths to compile per environment.
  defp elixirc_paths(:test), do: ["lib", "test/support"]
  defp elixirc_paths(_), do: ["lib"]

  # Specifies your project dependencies.
  #
  # Type `mix help deps` for examples and options.
  defp deps do
    [
      {:phoenix, "~> 1.4.11"},
      {:phoenix_pubsub, "~> 1.1"},
      {:gettext, "~> 0.11"},
      {:jason, "~> 1.0"},
      {:plug_cowboy, "~> 2.0"},
#      {:cowboy, github: "elixir-grpc/cowboy", override: true},
#      {:cowlib, github: "elixir-grpc/cowlib", override: true},
      {:grpc, github: "elixir-grpc/grpc"},
      {:protobuf, "~> 0.14.0"},
      {:google_protos, "~> 0.1"},
    ]
  end
end
