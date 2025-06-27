package spring.boot.stock.trade.ddd.application.rest;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderRequest {

    private String id;
    private String userId;
    private String stockId;
    private BigDecimal quantity;
    private String orderType;

}
