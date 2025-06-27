package spring.boot.stock.trade.ddd.application.rest;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class PortfolioResponse {

    private String id;
    private String userId;
    private BigDecimal totalValue;
    private String stocksInUserPortFolio;
    private Timestamp createdAt;
}
