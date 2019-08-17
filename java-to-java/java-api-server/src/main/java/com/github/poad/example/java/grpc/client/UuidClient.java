package com.github.poad.example.java.grpc.client;

import com.github.poad.example.grpc.GenerateUUIDRequest;
import com.github.poad.example.grpc.UUIDEntity;
import com.github.poad.example.grpc.UUIDGeneratorGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class UuidClient extends ClientBase {
    private final UUIDGeneratorGrpc.UUIDGeneratorBlockingStub uuidService;

    public UuidClient(@Autowired EndpointConfig config) {
        super(config.getHost(), config.getPort());

        uuidService = UUIDGeneratorGrpc.newBlockingStub(channel);
    }

    public UUIDEntity generateUUID() {
        return uuidService.generateUUID(GenerateUUIDRequest.getDefaultInstance());
    }
}
