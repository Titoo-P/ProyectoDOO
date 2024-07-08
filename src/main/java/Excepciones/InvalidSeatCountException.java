package Excepciones;

public class InvalidSeatCountException extends RuntimeException {
    public InvalidSeatCountException(String message) {
        super(message);
    }
}
