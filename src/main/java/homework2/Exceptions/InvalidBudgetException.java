package homework2.Exceptions;

public class InvalidBudgetException extends RuntimeException {

    public InvalidBudgetException() {
    }

    public InvalidBudgetException(String message) {
        super(message);
    }
}
