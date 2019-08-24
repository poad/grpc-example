defmodule ElixirApiServerWeb.MessageController do
  use ElixirApiServerWeb, :controller

  @moduledoc false

  def list( conn, _params ) do
    messages = ElixirApiServerWeb.MessageModel.list()
    render( conn, "list.json", api_data: messages )
  end

  def get( conn, %{"id" => id} ) do
    message = ElixirApiServerWeb.MessageModel.get(id)
    render( conn, "message.json", api_data: message )
  end

  def create( conn, %{"message" => message} ) do
    message = ElixirApiServerWeb.MessageModel.create(message)
    render( conn, "create.json", api_data: message )
  end

  def update( conn, %{"id" => id, "message" => message} ) do
    message = ElixirApiServerWeb.MessageModel.update(id, message)
    render( conn, "update.json", api_data: message )
  end

  def delete(conn, %{"id" => id}) do
    ElixirApiServerWeb.MessageModel.delete(id)
    send_resp(conn, :no_content, "")
  end

  def delete_all(conn, _params) do
    ElixirApiServerWeb.MessageModel.delete_all()
    send_resp(conn, :no_content, "")
  end

end
