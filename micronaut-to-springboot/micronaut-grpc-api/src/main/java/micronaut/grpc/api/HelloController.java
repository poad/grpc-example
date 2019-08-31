package micronaut.grpc.api;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.validation.Validated;
import micronaut.grpc.api.client.HelloClient;
import micronaut.grpc.api.model.HelloMessage;

import javax.inject.Inject;

@Validated
@Controller("/hello")
public class HelloController {

    @Inject
    HelloClient client;

    @Get(produces = MediaType.APPLICATION_JSON)
    public HelloMessage sayHello(@QueryValue("name") String name) {
        return new HelloMessage(client.sayHello(name));
    }
}
