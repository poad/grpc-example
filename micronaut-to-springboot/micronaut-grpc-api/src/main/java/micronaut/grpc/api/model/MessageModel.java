package micronaut.grpc.api.model;

public class MessageModel {
    private final String id;
    private final String message;

    public MessageModel() {
        this(null, null);
    }

    public MessageModel(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
