package com.github.poad.example.micronaut.grpc.repository;

import com.github.poad.example.micronaut.grpc.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
    @Query(value = "SELECT UUID()", nativeQuery = true)
    String uuid();
}
