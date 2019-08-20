defmodule Message.Server do
  use GRPC.Server, service: Message.Messenger.Service
  import Ecto.Query
  require Logger

  @spec put_message(Message.MessageEntity.t(), GRPC.Server.Stream.t()) ::
          Message.MessageEntity.t()
  def put_message(request, _stream) do
    message = Message.Repo.get(Message.Message, request.id().value())
    result = if message != nil do
      changeset = Ecto.Changeset.change message
      changeset = Ecto.Changeset.put_change(changeset, :message, request.message)
      Message.Repo.update changeset
    else
      Message.Repo.insert %Message.Message{ id: request.id.value, message: request.message }
    end
    case result do
      {:ok, struct} -> Message.MessageEntity.new(id: request.id, message: request.message)
      _ -> raise "Failed to insert or update"
    end
  end

  @spec list_messages(Message.GetMessagesRequest.t(), GRPC.Server.Stream.t()) ::
          Message.MessagesResponse.t()
  def list_messages(request, _stream) do
    query = from m in Message.Message,
                 select: m

    records = Enum.map(
      Message.Repo.all(query),
      fn (record) -> Message.MessageEntity.new(id: Message.UUIDEntity.new(value: record.id), message: record.message) end
    )

    Message.MessagesResponse.new(messages: records)
  end

  @spec get_message(Message.GetMessageRequest.t(), GRPC.Server.Stream.t()) ::
          Message.MessageEntity.t()
  def get_message(request, _stream) do
    case Message.Repo.get_by(Message.Message, [id: request.id.value]) do
      nil -> raise "Failed to get_message"
      _ = record -> Message.MessageEntity.new(id: Message.UUIDEntity.new(value: record.id), message: record.message)
    end
  end

  @spec delete_message(Message.DeleteMessageRequest.t, GRPC.Server.Stream.t()) ::
        Message.MessageEntity.t()
  def delete_message(request, _stream) do
    message = Message.Repo.get(Message.Message, request.id().value())
    result = if message != nil do
      changeset = Ecto.Changeset.change message
      Message.Repo.delete changeset
    else
      raise "Failed to get_message"
    end
    case result do
      {:ok, struct} -> Message.MessageEntity.new(id: request.id, message: message.message)
      _ -> raise "Failed to delete"
    end
  end

  @spec delete_messages(Message.DeleteMessagesRequest.t, GRPC.Server.Stream.t()) ::
          Message.DeleteMessagesResponse.t()
  def delete_messages(request, _stream) do
    Message.Repo.delete_all(Message.Message)
    Message.DeleteMessagesResponse.new()
  end

  @spec count_messages(Message.CountMessagesRequest.t(), GRPC.Server.Stream.t()) ::
          Message.MessageCount.t()
  def count_messages(request, _stream) do
    result = Ecto.Adapters.SQL.query!(Message.Repo, "SELECT count(id) AS COUNT FROM message")
    count = Enum.at(result.rows, 0)
    Message.MessageCount.new(count: count)
  end
end
