package spring.boot.stock.trade.ddd.infrastructure;

import org.springframework.stereotype.Component;
import spring.boot.stock.trade.ddd.domain.Identifier;
import spring.boot.stock.trade.ddd.domain.Order;
import spring.boot.stock.trade.ddd.domain.OrderStatus;
import spring.boot.stock.trade.ddd.domain.OrderType;
import spring.boot.stock.trade.ddd.infrastructure.entities.OrderEntity;

@Component
public class OrderEntityMapper implements EntityMapper<OrderEntity, Order> {
    @Override
    public OrderEntity convertToEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId().uuid());
        orderEntity.setUserId(order.getUserId().uuid());
        orderEntity.setStockId(order.getStockId().uuid());
        orderEntity.setOrderStatus(order.getOrderStatus().name());
        orderEntity.setOrderType(order.getOrderType().name());
        orderEntity.setQuantity(order.getQuantity());
        orderEntity.setCreatedTimestamp(order.getCreatedTimestamp());
        orderEntity.setPricePerShare(order.getPricePerShare());
        return orderEntity;
    }

    @Override
    public Order convertFromEntity(OrderEntity orderEntity) {
        Order order = new Order(new Identifier(orderEntity.getId()));
        order.setStockId(new Identifier(orderEntity.getStockId()));
        order.setUserId(new Identifier(orderEntity.getUserId()));
        order.setOrderStatus(OrderStatus.valueOf(orderEntity.getOrderStatus()));
        order.setOrderType(OrderType.valueOf(orderEntity.getOrderType()));
        order.setQuantity(orderEntity.getQuantity());
        order.setCreatedTimestamp(orderEntity.getCreatedTimestamp());
        order.setPricePerShare(orderEntity.getPricePerShare());
        return order;
    }
}
