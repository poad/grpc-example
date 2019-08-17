defmodule GrpcServer do
  use Application
  require Logger

  def start(_type, _args) do
    import Supervisor.Spec

    Logger.info "Starting Application..."

    Logger.info "Starting Server..."
    Supervisor.start_link(
      [
        Message.Repo,
        UUIDGen.Repo,
        supervisor(
          GRPC.Server.Supervisor,
          [
            {Hello.Endpoint, 50050}
          ],
          id: :hello_server
        ),
        supervisor(
          GRPC.Server.Supervisor,
          [
            {Message.Endpoint, 50051}
          ],
          id: :message_server
        ),
        supervisor(
          GRPC.Server.Supervisor,
          [
            {UUIDGen.Endpoint, 50052}
          ],
          id: :uuid_gen_server
        ),
      ],
      [
        strategy: :one_for_all,
        name: GrpcServer,
      ]
    )
  end
end
