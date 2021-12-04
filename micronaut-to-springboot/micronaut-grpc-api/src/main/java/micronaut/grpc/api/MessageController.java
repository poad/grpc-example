package micronaut.grpc.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import micronaut.grpc.api.client.MessageClient;
import micronaut.grpc.api.model.MessageModel;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@Controller("/message")
public class MessageController {

    private MessageClient client;

    @Inject
    public MessageController(MessageClient client) {
        this.client = client;
    }

    @Get
    public List<MessageModel> list() {
        return client.list();
    }

    @Get("/{id}")
    public MessageModel findById(String id) {
        return client.getById(id);
    }

    @Post(consumes = MediaType.APPLICATION_JSON)
    public MessageModel create(@Body @NotNull MessageModel message) {
        return client.create(message.getMessage());
    }

    @Put(value = "/{id}", consumes = MediaType.APPLICATION_JSON)
    public MessageModel update(String id, @Body @NotNull MessageModel message) {
        return client.update(id, message.getMessage());
    }

    @Delete(value = "/{id}")
    public HttpResponse deleteById(String id) {
        client.deleteById(id);
        return HttpResponse.noContent();
    }

    @Delete
    public HttpResponse deleteAll() {
        client.deleteMessages();
        return HttpResponse.noContent();
    }
}
