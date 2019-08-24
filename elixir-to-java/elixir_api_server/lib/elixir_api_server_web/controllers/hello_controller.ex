defmodule ElixirApiServerWeb.HelloController do
  use ElixirApiServerWeb, :controller

  @moduledoc false

  def index( conn, params ) do
    message = ElixirApiServerWeb.HelloModel.say_hello(params["name"])
    render( conn, "index.json", api_data: %{message: message} )
  end
end
