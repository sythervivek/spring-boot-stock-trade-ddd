package spring.boot.stock.trade.ddd.domain.services;

import spring.boot.stock.trade.ddd.domain.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class OrderService {

    private final StockTradingRepository stockTradingRepository;

    public OrderService(StockTradingRepository stockTradingRepository) {
        this.stockTradingRepository = stockTradingRepository;
    }

    public Identifier createOrder(Identifier stockId, BigDecimal quantity, Identifier userId, OrderType orderType) {
        Order order = new Order(new Identifier(UUID.randomUUID()));
        order.setUserId(userId);
        order.setStockId(stockId);
        order.setQuantity(quantity);
        order.setOrderType(orderType);
        order.setPricePerShare(stockTradingRepository.getPricePerStockByStockId(stockId));
        order.setOrderStatus(OrderStatus.ORDER_CREATED);
        order.setCreatedTimestamp(Timestamp.valueOf(LocalDateTime.now()));

        return stockTradingRepository.saveOrder(order);
    }

    public Optional<Order> findMatchingOrderAgainstOrder(Order order) {
        if (order.getOrderType() == OrderType.BUY_ORDER) {
            return stockTradingRepository.findOrderByStock(order.getStockId(), order.getQuantity(), OrderType.SELL_ORDER);
        } else {
            return stockTradingRepository.findOrderByStock(order.getStockId(), order.getQuantity(), OrderType.BUY_ORDER);
        }
    }

    public Optional<Order> findOrderById(Identifier identifier) {
        return stockTradingRepository.findOrderByOrderId(new Identifier(identifier.uuid()));
    }
}
