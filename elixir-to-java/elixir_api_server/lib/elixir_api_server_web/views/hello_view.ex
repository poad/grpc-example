defmodule ElixirApiServerWeb.HelloView do
  use ElixirApiServerWeb, :view
  @moduledoc false
  def render( "index.json", %{ api_data: params } ) do
    %{
      message: params.message
    }
  end

end
