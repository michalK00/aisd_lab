package L7.z1.CustomExeptions;

public class EmptyQueueException extends Exception {
    public EmptyQueueException(String message) {
        super(message);
    }
}
