FROM postgres:alpine

RUN apk add --no-cache postgresql-contrib

ADD ./rust-grpc-server/migrations/00000000000000_diesel_initial_setup/up.sql /docker-entrypoint-initdb.d/01_init_database.sql
ADD ./rust-grpc-server/migrations/2019-06-09-160224_create_messages/up.sql /docker-entrypoint-initdb.d/02_create_table.sql

EXPOSE 5432
