defmodule GrpcServerTest do
  use ExUnit.Case
  doctest GrpcServer

  test "greets the world" do
    assert GrpcServer.hello() == :world
  end
end
