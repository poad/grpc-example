defmodule UUIDGen.Endpoint do
  @moduledoc false
  use GRPC.Endpoint

  intercept GRPC.Logger.Server
  run UUIDGen.Server
end
