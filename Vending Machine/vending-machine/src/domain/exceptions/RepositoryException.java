package domain.exceptions;

public abstract class RepositoryException extends Exception {
    protected RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
