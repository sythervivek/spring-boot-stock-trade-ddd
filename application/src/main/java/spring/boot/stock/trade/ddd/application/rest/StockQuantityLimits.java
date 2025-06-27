package spring.boot.stock.trade.ddd.application.rest;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum StockQuantityLimits {
    MAXIMUM_STOCK_ORDER_QUANTITY (BigDecimal.valueOf(1000)),
    MINIMUM_STOCK_ORDER_QUANTITY (BigDecimal.valueOf(10));

    private final BigDecimal stockLimit;
    StockQuantityLimits(BigDecimal stockLimit) {
        this.stockLimit = stockLimit;
    }
}
