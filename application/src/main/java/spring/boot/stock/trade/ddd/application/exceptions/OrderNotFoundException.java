package spring.boot.stock.trade.ddd.application.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
