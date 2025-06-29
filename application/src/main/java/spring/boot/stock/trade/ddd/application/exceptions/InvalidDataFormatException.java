package spring.boot.stock.trade.ddd.application.exceptions;

public class InvalidDataFormatException extends RuntimeException{

    public InvalidDataFormatException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
