FROM elixir:alpine

RUN apk update \
 && apk add git

RUN mkdir -p /root/app
COPY ./config /root/app/config
COPY ./lib /root/app/lib
COPY ./priv /root/app/priv
COPY ./mix.exs /root/app/mix.exs

WORKDIR /root/app

RUN mix local.hex --force \
 && mix local.rebar --force \
 && mix deps.get \
 && mix deps.update --all \
 && MIX_ENV=prod mix compile

ENV MIX_ENV=prod

CMD [ "mix", "grpc.server" ]
