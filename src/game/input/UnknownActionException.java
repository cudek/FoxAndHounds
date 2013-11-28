package game.input;

public class UnknownActionException extends Exception {

    public UnknownActionException() {
        super();
    }

    public UnknownActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownActionException(String message) {
        super(message);
    }

    public UnknownActionException(Throwable cause) {
        super(cause);
    }

}
