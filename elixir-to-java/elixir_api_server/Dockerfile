FROM elixir:alpine

RUN apk update \
 && apk add git make

RUN mkdir -p /root/app
COPY ./config /root/app/config
COPY ./lib /root/app/lib
COPY ./priv /root/app/priv
COPY ./mix.exs /root/app/mix.exs

WORKDIR /root/app

RUN mix local.hex --force \
 && mix local.rebar --force \
 && mix deps.get \
 && MIX_ENV=dev mix compile

ENV MIX_ENV=dev

CMD [ "mix", "phx.server" ]
