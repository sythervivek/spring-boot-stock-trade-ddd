package spring.boot.stock.trade.ddd.application.rest;

import org.springframework.stereotype.Component;
import spring.boot.stock.trade.ddd.domain.Identifier;
import spring.boot.stock.trade.ddd.domain.Order;
import spring.boot.stock.trade.ddd.domain.OrderType;

import java.util.UUID;

@Component
public class OrderModelMapper implements ModelMapper<OrderRequest, OrderResponse, Order> {

    @Override
    public OrderResponse convertToModel(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId().uuid().toString());
        orderResponse.setUserId(order.getUserId().uuid().toString());
        orderResponse.setStockId(order.getStockId().uuid().toString());
        orderResponse.setOrderStatus(order.getOrderStatus().name());
        orderResponse.setOrderType(order.getOrderType().name());
        orderResponse.setQuantity(order.getQuantity());
        orderResponse.setCreatedTimestamp(order.getCreatedTimestamp());
        orderResponse.setPricePerShare(order.getPricePerShare());
        return orderResponse;
    }

    @Override
    public Order convertFromModel(OrderRequest request) {
        Order order = new Order(new Identifier(UUID.fromString(request.getId())));
        order.setStockId(new Identifier(UUID.fromString(request.getStockId())));
        order.setUserId(new Identifier(UUID.fromString(request.getUserId())));
        order.setOrderType(OrderType.valueOf(request.getOrderType()));
        order.setQuantity(request.getQuantity());
        return order;
    }
}
