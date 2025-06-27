package spring.boot.stock.trade.ddd.application.exceptions;

public class PortfolioNotFoundException extends RuntimeException {
    public PortfolioNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
