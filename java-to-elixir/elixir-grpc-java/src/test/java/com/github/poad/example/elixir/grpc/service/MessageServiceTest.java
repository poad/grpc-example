package com.github.poad.example.elixir.grpc.service;

import io.grpc.testing.GrpcServerRule;
import org.junit.Rule;
import org.junit.Test;

public class MessageServiceTest {

    @Rule
    public GrpcServerRule grpcServerRule = new GrpcServerRule().directExecutor();

    @Test
    public void test() {
    }
}
