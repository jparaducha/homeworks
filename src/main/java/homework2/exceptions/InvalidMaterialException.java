package homework2.exceptions;

public class InvalidMaterialException extends Exception {
    public InvalidMaterialException() {
    }

    public InvalidMaterialException(String message) {
        super(message);
    }
}
