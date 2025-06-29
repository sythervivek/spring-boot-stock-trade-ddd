package spring.boot.stock.trade.ddd.application.exceptions;

public class InvalidOrderTypeException extends RuntimeException {

    public InvalidOrderTypeException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
