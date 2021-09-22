defmodule Hello.HelloRequest do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{
          name: String.t()
        }

  defstruct [:name]

  field :name, 1, type: :string
end

defmodule Hello.HelloReply do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{
          message: String.t()
        }

  defstruct [:message]

  field :message, 1, type: :string
end

defmodule Hello.Greeter.Service do
  @moduledoc false
  use GRPC.Service, name: "hello.Greeter"

  rpc :SayHello, Hello.HelloRequest, Hello.HelloReply
end

defmodule Hello.Greeter.Stub do
  @moduledoc false
  use GRPC.Stub, service: Hello.Greeter.Service
end
