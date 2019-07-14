use super::schema::message;

#[derive(Queryable, Insertable, Debug)]
#[table_name = "message"]
pub struct Message {
    pub id: String,
    pub content: String
}
