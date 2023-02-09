package domain.exceptions;

public class OutOfStockException extends RepositoryException{
    private final String message = "Products of type %s are out of stock";
    protected OutOfStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
