package spring.boot.stock.trade.ddd.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private final Identifier id;
    private Identifier userId;
    private BigDecimal totalValue;
    private Map<Identifier, BigDecimal> stocksInUserPortFolio;
    private Timestamp createdAt;

    public Portfolio(Identifier id) {
        this.id = id;
        this.stocksInUserPortFolio = new HashMap<>(Map.of());
    }

    public Identifier getId() {
        return id;
    }

    public Identifier getUserId() {
        return userId;
    }

    public void setUserId(Identifier userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public Map<Identifier, BigDecimal> getStocksInUserPortFolio() {
        return stocksInUserPortFolio;
    }

    public void setStocksInUserPortFolio(Map<Identifier, BigDecimal> stocksInUserPortFolio) {
        this.stocksInUserPortFolio = stocksInUserPortFolio;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


}
