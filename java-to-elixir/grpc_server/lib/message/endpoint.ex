defmodule Message.Endpoint do
  @moduledoc false
  use GRPC.Endpoint

  intercept GRPC.Logger.Server
  run Message.Server
end
