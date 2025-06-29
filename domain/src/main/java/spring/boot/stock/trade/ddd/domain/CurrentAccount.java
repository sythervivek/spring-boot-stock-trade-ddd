package spring.boot.stock.trade.ddd.domain;

import java.math.BigDecimal;

public class CurrentAccount extends Account{
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
