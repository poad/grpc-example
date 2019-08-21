defmodule Message.Repo do
  use Ecto.Repo, adapter: Ecto.Adapters.MyXQL, otp_app: :grpc_server
end
