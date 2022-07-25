defmodule Message.UUIDEntity do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3

  field :value, 1, type: :string
end
defmodule Message.GenerateUUIDRequest do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3
end
defmodule Message.MessageEntity do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3

  field :id, 1, type: Message.UUIDEntity
  field :message, 2, type: :string
end
defmodule Message.GetMessageRequest do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3

  field :id, 1, type: Message.UUIDEntity
end
defmodule Message.GetMessagesRequest do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3
end
defmodule Message.DeleteMessagesRequest do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3
end
defmodule Message.DeleteMessageRequest do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3

  field :id, 1, type: Message.UUIDEntity
end
defmodule Message.CountMessagesRequest do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3
end
defmodule Message.MessageCount do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3

  field :count, 1, type: :int64
end
defmodule Message.DeleteMessagesResponse do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3
end
defmodule Message.MessagesResponse do
  @moduledoc false
  use Protobuf, protoc_gen_elixir_version: "0.10.0", syntax: :proto3

  field :messages, 1, repeated: true, type: Message.MessageEntity
end
defmodule Message.UUIDGenerator.Service do
  @moduledoc false
  use GRPC.Service, name: "message.UUIDGenerator", protoc_gen_elixir_version: "0.10.0"

  rpc :GenerateUUID, Message.GenerateUUIDRequest, Message.UUIDEntity
end

defmodule Message.UUIDGenerator.Stub do
  @moduledoc false
  use GRPC.Stub, service: Message.UUIDGenerator.Service
end
defmodule Message.Messenger.Service do
  @moduledoc false
  use GRPC.Service, name: "message.Messenger", protoc_gen_elixir_version: "0.10.0"

  rpc :GetMessage, Message.GetMessageRequest, Message.MessageEntity

  rpc :ListMessages, Message.GetMessagesRequest, Message.MessagesResponse

  rpc :PutMessage, Message.MessageEntity, Message.MessageEntity

  rpc :DeleteMessage, Message.DeleteMessageRequest, Message.MessageEntity

  rpc :DeleteMessages, Message.DeleteMessagesRequest, Message.DeleteMessagesResponse

  rpc :CountMessages, Message.CountMessagesRequest, Message.MessageCount
end

defmodule Message.Messenger.Stub do
  @moduledoc false
  use GRPC.Stub, service: Message.Messenger.Service
end
