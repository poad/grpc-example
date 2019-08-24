defmodule ElixirApiServerWeb.HelloModel do
  @moduledoc false

  def say_hello(name) do
    endpoint = System.get_env("GRPC_ENDPOINT")
    endpoint = if endpoint == nil do
      "127.0.0.1"
    else
      endpoint
    end
    {:ok, channel} = GRPC.Stub.connect("#{endpoint}:50051")
    request = Hello.HelloRequest.new(name: name)
    {:ok, reply} = channel |> Hello.Greeter.Stub.say_hello(request)
    reply.message
  end
end
