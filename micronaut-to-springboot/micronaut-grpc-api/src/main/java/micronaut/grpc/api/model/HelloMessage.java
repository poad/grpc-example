package micronaut.grpc.api.model;

public class HelloMessage {
    private final String messaeg;

    public HelloMessage(String messaeg) {
        this.messaeg = messaeg;
    }

    public String getMessaeg() {
        return messaeg;
    }
}
