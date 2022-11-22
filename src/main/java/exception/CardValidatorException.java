package exception;

public class CardValidatorException extends Exception {
    public CardValidatorException() {
    }

    public CardValidatorException(String message) {
        super(message);
    }

    public CardValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardValidatorException(Throwable cause) {
        super(cause);
    }

}
