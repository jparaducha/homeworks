package homework2.exceptions;

public class InvalidBudgetException extends RuntimeException {

    public InvalidBudgetException() {
    }

    public InvalidBudgetException(String message) {
        super(message);
    }
}
