package micronaut.grpc.api.client;

import com.github.poad.example.grpc.GreeterGrpc;
import com.github.poad.example.grpc.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.Optional;

@Named
@Singleton
public class HelloClient {
    private final GreeterGrpc.GreeterBlockingStub helloService;

    public HelloClient() {
        Map<String, String> env = System.getenv();
        String endpoint = env.getOrDefault("GRPC_ENDPOINT", "127.0.0.1");
        int port = Optional.ofNullable(env.get("GRPC_ENDPOINT_PORT"))
                .map(Integer::valueOf).orElse(50051);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(endpoint, port)
                .usePlaintext().build();

        helloService = GreeterGrpc.newBlockingStub(channel);
    }

    public String sayHello(@NotBlank String name) {
        return helloService.sayHello(HelloRequest.newBuilder().setName(name).build())
                .getMessage();
    }

}
