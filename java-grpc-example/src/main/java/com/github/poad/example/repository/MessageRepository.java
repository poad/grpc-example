package com.github.poad.example.repository;

import com.github.poad.example.grpc.MessageEntity;
import com.github.poad.example.grpc.UUIDEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;

@Valid
@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, String> {
    UUIDEntity generateUUID();
}
