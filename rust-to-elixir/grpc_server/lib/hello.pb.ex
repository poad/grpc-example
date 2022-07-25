defmodule Hello.HelloRequest do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3

  field :name, 1, type: :string
end
defmodule Hello.HelloReply do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3

  field :message, 1, type: :string
end
defmodule Hello.Greeter.Service do
  @moduledoc false
  use GRPC.Service, name: "hello.Greeter", protoc_gen_elixir_version: "0.10.0"

  rpc :SayHello, Hello.HelloRequest, Hello.HelloReply
end

defmodule Hello.Greeter.Stub do
  @moduledoc false
  use GRPC.Stub, service: Hello.Greeter.Service
end
