defmodule Hello.Endpoint do
  @moduledoc false
  use GRPC.Endpoint

  intercept GRPC.Logger.Server
  run Hello.Server
end
