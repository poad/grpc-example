defmodule ElixirApiServerWeb.MessageView do
  use ElixirApiServerWeb, :view
  @moduledoc false

  def render( "list.json", %{ api_data: params } ) do
    Enum.map(params, fn(message) -> %{id: message.id.value, message: message.message} end)
  end

  def render( "message.json", %{ api_data: param } ) do
    %{id: param.id, message: param.message}
  end

  def render( "create.json", %{ api_data: param } ) do
    %{id: param.id, message: param.message}
  end

  def render( "update.json", %{ api_data: param } ) do
    %{id: param.id, message: param.message}
  end

end
