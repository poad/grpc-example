#[macro_use]
extern crate diesel;
extern crate dotenv;
extern crate uuid;

use diesel::prelude::*;
use diesel::pg::PgConnection;
use dotenv::dotenv;
use std::env;
use uuid::Uuid;

pub mod schema;
pub mod models;

use self::models::Message;

pub fn establish_connection() -> PgConnection {
    dotenv().ok();

    let database_url = env::var("DATABASE_URL")
        .expect("DATABASE_URL must be set");
    PgConnection::establish(&database_url)
        .expect(&format!("Error connecting to {}", database_url))
}

pub fn generate_uuid(_conn: &PgConnection) -> String {

//    let uuid: &uuid::Uuid = diesel::sql_query("SELECT uuid_generate_v4();").load(_conn).expect("").first().unwrap();
//    // TODO SQLで生成するように変更する
    let uuid = Uuid::new_v4();
    uuid.hyphenated().to_string().clone()
}

pub fn create_message(conn: &PgConnection, id: &str, content: &str) -> Message {
    use self::schema::message;

    let entity = Message { id: id.to_string(), content: content.to_string() };

    diesel::insert_into(message::table)
        .values(entity)
        .get_result(conn)
        .expect("Error saving new message")
}

pub fn update_message(conn: &PgConnection, id: &str, content: &str) -> Message {
    use self::schema::message::dsl::message;

    diesel::update(message)
        .filter(schema::message::id.eq(id))
        .set(schema::message::content.eq(content))
        .get_result(conn)
        .expect("Error saving new message")

}

pub fn get_message(conn: &PgConnection, id: &str) -> Message {
    use self::schema::message::dsl::message;

    message.find(id)
        .get_result::<Message>(conn)
        .expect(&format!("Unable to find message {}", id))
}

pub fn list_massages(conn: &PgConnection) -> Vec<Message> {
    use self::schema::message::dsl::*;

    message.select((id, content))
        .load::<Message>(conn)
        .expect("Error listing messages")
}

pub fn count_massages(conn: &PgConnection) -> i64 {
    use diesel::dsl::*;
    use self::schema::message::dsl::*;

    let count = message.select(count(id))
        .first(conn)
        .expect("Error count messages");

    count
}

pub fn exists_message(conn: &PgConnection, id: &str) -> bool {
    use diesel::dsl::*;
    use self::schema::message::dsl::message;

    message.select(count(schema::message::id))
        .filter(schema::message::id.eq(id))
        .get_result::<i64>(conn)
        .expect("Error listing messages") > 0
}

pub fn delete_message(conn: &PgConnection, id: &str) -> () {
    use self::schema::message::dsl::message;

    diesel::delete(message)
        .filter(schema::message::id.eq(id))
        .execute(conn)
        .expect(&format!("Unable to delete message {}", id));
}


pub fn delete_messages(conn: &PgConnection) -> () {
    use self::schema::message::dsl::message;

    diesel::delete(message)
        .execute(conn)
        .expect("Unable to delete messages");
}
