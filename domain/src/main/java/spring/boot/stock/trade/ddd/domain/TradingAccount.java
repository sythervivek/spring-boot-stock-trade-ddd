package spring.boot.stock.trade.ddd.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TradingAccount extends Account {

    public TradingAccount(){
        this.stockData = new HashMap<>(Map.of());
    }
    public Map<Identifier, BigDecimal> getStockData() {
        return stockData;
    }

    public void setStockData(Map<Identifier, BigDecimal> stockData) {
        this.stockData = stockData;
    }

    private Map<Identifier, BigDecimal> stockData;

}
