package spring.boot.stock.trade.ddd.application.services;

import org.springframework.stereotype.Service;
import spring.boot.stock.trade.ddd.domain.Identifier;
import spring.boot.stock.trade.ddd.domain.Order;
import spring.boot.stock.trade.ddd.domain.services.OrderService;

@Service
public class OrderApplicationService {

private final OrderService orderService;

public OrderApplicationService(OrderService orderService) {
    this.orderService = orderService;
}

    public String createOrder(Order order) {
        Identifier orderId = orderService.createOrder(order.getStockId(), order.getQuantity(), order.getUserId(), order.getOrderType());
        return orderId.uuid().toString();
    }

    public Order getOrderById(Identifier orderId) {
        return orderService.findOrderById(orderId).orElseThrow();
    }

}
