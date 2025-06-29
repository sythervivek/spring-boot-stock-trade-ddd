package spring.boot.stock.trade.ddd.application.exceptions;

public class InvalidIdentifierException extends RuntimeException {

    public InvalidIdentifierException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
