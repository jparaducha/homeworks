package homework2.Exceptions;

public class InvalidMaterialException extends Exception {
    public InvalidMaterialException() {
    }

    public InvalidMaterialException(String message) {
        super(message);
    }
}
