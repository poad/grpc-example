defmodule Message.Repo.Migrations.CreateMessage do
  use Ecto.Migration

  def change do
    create table(:message, primary_key: false) do
      add :id, :string, null: false, primary_key: true
      add :message, :string, null: false
    end

    create unique_index :message, [:id, :message], name: :message_unique_IDX
  end
end