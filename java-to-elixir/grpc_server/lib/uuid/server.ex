defmodule UUIDGen.Server do
  use GRPC.Server, service: Message.UUIDGenerator.Service
  import Ecto.Query
  require Logger

  @spec generate_uuid(Message.GenerateUUIDRequest.t, GRPC.Server.Stream.t()) ::
          Message.UUIDEntity.t()
  def generate_uuid(request, _stream) do
    Logger.info "UUID Gen"
    result = Ecto.Adapters.SQL.query!(UUIDGen.Repo, "SELECT UUID() AS UUID")
    id = Enum.at(result.rows, 0)
    Message.UUIDEntity.new(value: id)
  end
end
