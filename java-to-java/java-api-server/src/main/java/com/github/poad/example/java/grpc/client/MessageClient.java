package com.github.poad.example.java.grpc.client;

import com.github.poad.example.grpc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class MessageClient extends ClientBase {
    private final MessengerGrpc.MessengerBlockingStub messageService;

    public MessageClient(@Autowired EndpointConfig config) {
        super(config.getHost(), config.getPort());

        messageService = MessengerGrpc.newBlockingStub(channel);
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
