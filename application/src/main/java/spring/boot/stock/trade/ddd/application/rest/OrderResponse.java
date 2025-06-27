package spring.boot.stock.trade.ddd.application.rest;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class OrderResponse {

    private String id;
    private String userId;
    private String stockId;
    private BigDecimal quantity;
    private String orderType;
    private BigDecimal pricePerShare;
    private String orderStatus;
    private Timestamp createdTimestamp;
}
