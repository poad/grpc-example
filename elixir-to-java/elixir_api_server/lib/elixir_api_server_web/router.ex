defmodule ElixirApiServerWeb.Router do
  use ElixirApiServerWeb, :router

  pipeline :api do
    plug :accepts, ["json"]
  end

  scope "/hello", ElixirApiServerWeb do
    pipe_through :api

    get "/", HelloController, :index
  end

  scope "/message", ElixirApiServerWeb do
    pipe_through :api

    get "/", MessageController, :list

    get "/:id", MessageController, :get

    post "/", MessageController, :create

    put "/:id", MessageController, :update

    delete "/:id", MessageController, :delete

    delete "/", MessageController, :delete_all
  end
end
