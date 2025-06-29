package spring.boot.stock.trade.ddd.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private final Identifier id;
    private Identifier userId;
    private Identifier stockId;
    private BigDecimal quantity;
    private OrderType orderType;
    private BigDecimal pricePerShare;
    private OrderStatus orderStatus;
    private Timestamp createdTimestamp;

    public Order(Identifier id) {
        this.id = id;
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

    public Identifier getStockId() {
        return stockId;
    }

    public void setStockId(Identifier stockId) {
        this.stockId = stockId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(BigDecimal pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

}
