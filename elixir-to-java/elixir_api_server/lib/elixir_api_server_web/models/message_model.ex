defmodule ElixirApiServerWeb.MessageModel do
  @moduledoc false
  require Logger

  def list() do
    endpoint = System.get_env("GRPC_ENDPOINT")
    endpoint = if endpoint == nil do
      "127.0.0.1"
    else
      endpoint
    end
    Logger.info("connect to #{endpoint}:50051")

    {:ok, channel} = GRPC.Stub.connect("#{endpoint}:50051")
    request = Message.GetMessagesRequest.new()
    {:ok, reply} = channel |> Message.Messenger.Stub.list_messages(request)
    reply.messages
  end

  def get(id) do
    endpoint = System.get_env("GRPC_ENDPOINT")
    endpoint = if endpoint == nil do
      "127.0.0.1"
    else
      endpoint
    end
    Logger.info("connect to #{endpoint}:50051")

    {:ok, channel} = GRPC.Stub.connect("#{endpoint}:50051")
    request = Message.GetMessageRequest.new(id: Message.UUIDEntity.new(value: id))
    {:ok, reply} = channel |> Message.Messenger.Stub.get_message(request)
    %{id: reply.id.value, message: reply.message}
  end

  def create(message) do
    endpoint = System.get_env("GRPC_ENDPOINT")
    endpoint = if endpoint == nil do
      "127.0.0.1"
    else
      endpoint
    end
    Logger.info("connect to #{endpoint}:50051")

    {:ok, channel} = GRPC.Stub.connect("#{endpoint}:50051")
    request = Message.GenerateUUIDRequest.new()
    {:ok, reply} = channel |> Message.UUIDGenerator.Stub.generate_uuid(request)

    request = Message.MessageEntity.new(id: reply, message: message)
    {:ok, reply} = channel |> Message.Messenger.Stub.put_message(request)
    %{id: reply.id.value, message: reply.message}
  end

  def update(id, message) do
    endpoint = System.get_env("GRPC_ENDPOINT")
    endpoint = if endpoint == nil do
      "127.0.0.1"
    else
      endpoint
    end
    Logger.info("connect to #{endpoint}:50051")

    uuid = Message.UUIDEntity.new(value: id)
    {:ok, channel} = GRPC.Stub.connect("#{endpoint}:50051")
    {:ok, _reply} = channel |> Message.Messenger.Stub.get_message(Message.GetMessageRequest.new(id: uuid))

    {:ok, reply} = channel |> Message.Messenger.Stub.put_message(Message.MessageEntity.new(id: uuid, message: message))
    %{id: reply.id.value, message: reply.message}
  end

  def delete(id) do
    endpoint = System.get_env("GRPC_ENDPOINT")
    endpoint = if endpoint == nil do
      "127.0.0.1"
    else
      endpoint
    end
    Logger.info("connect to #{endpoint}:50051")

    {:ok, channel} = GRPC.Stub.connect("#{endpoint}:50051")
    request = Message.DeleteMessageRequest.new(id: Message.UUIDEntity.new(value: id))
    {:ok, _reply} = channel |> Message.Messenger.Stub.delete_message(request)
  end

  def delete_all() do
    endpoint = System.get_env("GRPC_ENDPOINT")
    endpoint = if endpoint == nil do
      "127.0.0.1"
    else
      endpoint
    end
    Logger.info("connect to #{endpoint}:50051")

    {:ok, channel} = GRPC.Stub.connect("#{endpoint}:50051")
    request = Message.DeleteMessagesRequest.new()
    {:ok, _reply} = channel |> Message.Messenger.Stub.delete_messages(request)
  end
end
