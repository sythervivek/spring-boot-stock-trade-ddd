package spring.boot.stock.trade.ddd.application.exceptions;

public class InvalidOrderQuantityException extends RuntimeException {

    public InvalidOrderQuantityException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
