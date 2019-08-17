defmodule Message.Schema do
  use Ecto.Schema
  defmacro __using__(_) do
    quote do
      use Ecto.Schema
      @primary_key {:id, :string, autogenerate: false}
    end
  end
end

defmodule Message.Message do
  use Message.Schema

  @primary_key {:id, :string, autogenerate: false}
  schema "message" do
    field :message
  end
end
