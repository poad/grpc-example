package micronaut.grpc.api.model;

public class MessageModel {
    private final String id;
    private final String mesasge;

    public MessageModel(String id, String mesasge) {
        this.id = id;
        this.mesasge = mesasge;
    }

    public String getId() {
        return id;
    }

    public String getMesasge() {
        return mesasge;
    }
}
