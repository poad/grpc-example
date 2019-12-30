package com.github.poad.example.grpc.client;

import com.github.poad.example.grpc.*;
import com.github.poad.example.grpc.client.config.EndpointConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class MessageClient extends ClientBase {
    private static final Logger logger = LogManager.getLogger(MessageClient.class.getPackageName());

    private final MessengerGrpc.MessengerBlockingStub messageService;
    private final UUIDGeneratorGrpc.UUIDGeneratorBlockingStub uuidService;

    public MessageClient(EndpointConfig config) {
        super(config.getHost(), config.getPort());

        logger.info("gRPC Server: " + config.getHost() + " [" + config.getPort() + "]");
        messageService = MessengerGrpc.newBlockingStub(channel);
        uuidService = UUIDGeneratorGrpc.newBlockingStub(channel);

    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public List<MessageEntity> getMessages() {
        GetMessagesRequest request = GetMessagesRequest.newBuilder().build();
        MessagesResponse response = messageService.listMessages(request);
        return response.getMessagesList();
    }

    public Optional<MessageEntity> getMessage(String id) {
        UUIDEntity uuid = UUIDEntity.newBuilder().setValue(id).build();
        GetMessageRequest request = GetMessageRequest.newBuilder().setId(uuid).build();
        MessageEntity result = messageService.getMessage(request);
        return Optional.ofNullable(result);
    }

    public UUIDEntity generateUUID() {
        return uuidService.generateUUID(GenerateUUIDRequest.getDefaultInstance());
    }

    public MessageEntity putMessage(MessageEntity entity) {
        return messageService.putMessage(entity);
    }

    public Optional<MessageEntity> deleteById(String id) {
        UUIDEntity uuid = UUIDEntity.newBuilder().setValue(id).build();
        MessageEntity entity = messageService.getMessage(
                GetMessageRequest.newBuilder().setId(uuid).build());
        if (entity != null) {
            return Optional.of(messageService.deleteMessage(
                    DeleteMessageRequest.newBuilder().setId(uuid).build()));
        }
        return Optional.empty();
    }

    public MessageEntity deleteMessage(MessageEntity entity) {
        return messageService.deleteMessage(
                DeleteMessageRequest.newBuilder().setId(entity.getId()).build());
    }

    public void deleteMessages() {
        messageService.deleteMessages(DeleteMessagesRequest.getDefaultInstance());
    }

    public MessageCount countMessages() {
        return messageService.countMessages(CountMessagesRequest.getDefaultInstance());
    }
}
