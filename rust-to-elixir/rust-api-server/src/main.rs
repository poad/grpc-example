extern crate grpcio;

use actix_web::{middleware, web, App, HttpServer};
use env_logger;
use rust_api_server::handlers;

fn main() {
    env_logger::init();

    HttpServer::new(|| {
        App::new()
            .wrap(middleware::Compress::default())
            .route("/hello/", web::get().to(handlers::hello))
            .route("/message/{id}/", web::get().to(handlers::get_massage))
            .route("/message/", web::get().to(handlers::get_massages))
            .route("/message/", web::post().to(handlers::create_message))
            .route("/message/{id}/", web::put().to(handlers::update_message))
            .route("/message/{id}/", web::delete().to(handlers::delete_message))
            .route("/message/", web::delete().to(handlers::delete_messages))
    })
    .bind("0.0.0.0:8080")
    .expect("Can not bind to port 8080")
    .run()
    .unwrap();
}
