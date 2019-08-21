defmodule Message.UUIDEntity do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{
          value: String.t()
        }
  defstruct [:value]

  field :value, 1, type: :string
end

defmodule Message.GenerateUUIDRequest do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{}
  defstruct []
end

defmodule Message.MessageEntity do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{
          id: Message.UUIDEntity.t() | nil,
          message: String.t()
        }
  defstruct [:id, :message]

  field :id, 1, type: Message.UUIDEntity
  field :message, 2, type: :string
end

defmodule Message.GetMessageRequest do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{
          id: Message.UUIDEntity.t() | nil
        }
  defstruct [:id]

  field :id, 1, type: Message.UUIDEntity
end

defmodule Message.GetMessagesRequest do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{}
  defstruct []
end

defmodule Message.DeleteMessagesRequest do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{}
  defstruct []
end

defmodule Message.DeleteMessageRequest do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{
          id: Message.UUIDEntity.t() | nil
        }
  defstruct [:id]

  field :id, 1, type: Message.UUIDEntity
end

defmodule Message.CountMessagesRequest do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{}
  defstruct []
end

defmodule Message.MessageCount do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{
          count: integer
        }
  defstruct [:count]

  field :count, 1, type: :int64
end

defmodule Message.DeleteMessagesResponse do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{}
  defstruct []
end

defmodule Message.MessagesResponse do
  @moduledoc false
  use Protobuf, syntax: :proto3

  @type t :: %__MODULE__{
          messages: [Message.MessageEntity.t()]
        }
  defstruct [:messages]

  field :messages, 1, repeated: true, type: Message.MessageEntity
end

defmodule Message.UUIDGenerator.Service do
  @moduledoc false
  use GRPC.Service, name: "message.UUIDGenerator"

  rpc :GenerateUUID, Message.GenerateUUIDRequest, Message.UUIDEntity
end

defmodule Message.UUIDGenerator.Stub do
  @moduledoc false
  use GRPC.Stub, service: Message.UUIDGenerator.Service
end

defmodule Message.Messenger.Service do
  @moduledoc false
  use GRPC.Service, name: "message.Messenger"

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
