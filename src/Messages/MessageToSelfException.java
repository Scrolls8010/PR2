package Messages;

public class MessageToSelfException extends MessengerException{

    public MessageToSelfException(String message) {
        super(message);
    }

    public MessageToSelfException(String message, Throwable cause) {
        super(message, cause);
    }
}
