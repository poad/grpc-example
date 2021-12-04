package micronaut.grpc.api.client;

import com.github.poad.example.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.inject.Singleton;
import micronaut.grpc.api.model.MessageModel;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class MessageClient {
    private final UUIDGeneratorGrpc.UUIDGeneratorBlockingStub uuidService;
    private final MessengerGrpc.MessengerBlockingStub messageService;

    public MessageClient() {
        Map<String, String> env = System.getenv();
        String endpoint = env.getOrDefault("GRPC_ENDPOINT", "127.0.0.1");
        int port = Optional.ofNullable(env.get("GRPC_ENDPOINT_PORT"))
                .map(Integer::valueOf).orElse(50051);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(endpoint, port)
                .usePlaintext().build();
        uuidService = UUIDGeneratorGrpc.newBlockingStub(channel);
        messageService = MessengerGrpc.newBlockingStub(channel);
    }

    public List<MessageModel> list() {
        return messageService.listMessages(GetMessagesRequest.newBuilder().build())
                .getMessagesList()
                .stream()
                .map(entity -> new MessageModel(entity.getId().getValue(), entity.getMessage()))
                .collect(Collectors.toList());
    }

    public MessageModel getById(@NotBlank String id) {
        UUIDEntity uuid = UUIDEntity.newBuilder().setValue(id).build();
        MessageEntity entity = messageService.getMessage(GetMessageRequest.newBuilder().setId(uuid).build());
        return new MessageModel(id, entity.getMessage());
    }

    public MessageModel create(@NotBlank String mesasge) {
        UUIDEntity uuid = uuidService.generateUUID(GenerateUUIDRequest.newBuilder().build());
        MessageEntity entity = messageService.putMessage(MessageEntity.newBuilder().setId(uuid).setMessage(mesasge).build());
        return new MessageModel(entity.getId().getValue(), entity.getMessage());
    }

    public MessageModel update(@NotBlank String id, @NotBlank String mesasge) {
        UUIDEntity uuid = UUIDEntity.newBuilder().setValue(id).build();
        MessageEntity entity = messageService.putMessage(MessageEntity.newBuilder().setId(uuid).setMessage(mesasge).build());
        return new MessageModel(entity.getId().getValue(), entity.getMessage());
    }

    public MessageModel deleteById(@NotBlank String id) {
        UUIDEntity uuid = UUIDEntity.newBuilder().setValue(id).build();
        MessageEntity entity = messageService.deleteMessage(DeleteMessageRequest.newBuilder().setId(uuid).build());
        return new MessageModel(id, entity.getMessage());
    }

    public void deleteMessages() {
        messageService.deleteMessages(DeleteMessagesRequest.newBuilder().build());
    }
}
