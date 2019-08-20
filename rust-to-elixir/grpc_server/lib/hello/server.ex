defmodule Hello.Server do
  @moduledoc false
  use GRPC.Server, service: Hello.Greeter.Service

  @spec say_hello(Hello.HelloRequest.t(), GRPC.Server.Stream.t()) ::
          Hello.HelloReply.t()
  def say_hello(request, _stream) do
    Hello.HelloReply.new(message: "Hello #{request.name}")
  end
end
