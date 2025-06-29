package spring.boot.stock.trade.ddd.application.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.stock.trade.ddd.application.exceptions.*;
import spring.boot.stock.trade.ddd.application.services.OrderApplicationService;
import spring.boot.stock.trade.ddd.domain.Identifier;
import spring.boot.stock.trade.ddd.domain.Order;
import spring.boot.stock.trade.ddd.domain.OrderType;

import java.util.UUID;


@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderApplicationService orderApplicationService;
    private final ModelMapper<OrderRequest, OrderResponse, Order> orderModelMapper;

    public OrderController(OrderApplicationService orderApplicationService, ModelMapper<OrderRequest, OrderResponse, Order> modelMapper) {
        this.orderApplicationService = orderApplicationService;
        this.orderModelMapper = modelMapper;
    }

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {

        validateId(orderRequest.getId(), "OrderId");
        validateId(orderRequest.getUserId(), "UserId");
        validateId(orderRequest.getStockId(), "Stock");

        if (orderRequest.getQuantity().compareTo(StockQuantityLimits.MAXIMUM_STOCK_ORDER_QUANTITY.getStockLimit()) > 0) {
            throw new InvalidOrderQuantityException("Stock quantity exceeds maximum limit", new Throwable());
        }

        if (orderRequest.getQuantity().compareTo(StockQuantityLimits.MINIMUM_STOCK_ORDER_QUANTITY.getStockLimit()) < 0) {
            throw new InvalidOrderQuantityException("Stock quantity less than minimum quantity", new Throwable());
        }

        if (!(orderRequest.getOrderType().equals(OrderType.SELL_ORDER.name()) || orderRequest.getOrderType().equals(OrderType.BUY_ORDER.name()))) {
            throw new InvalidOrderTypeException("Order Type provided, is invalid", new Throwable());
        }
        return new ResponseEntity<String>(orderApplicationService.createOrder(orderModelMapper.convertFromModel(orderRequest)), HttpStatus.CREATED);
    }


    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("id") String orderId) {
        OrderResponse orderResponse = new OrderResponse();
        validateId(orderId, "OrderId");
        Order order = orderApplicationService.getOrderById(new Identifier(UUID.fromString(orderId)));

        if (order == null) {
            throw new OrderNotFoundException("Order Not Found", new Throwable());
        }
        try {
            orderResponse = orderModelMapper.convertToModel(order);
        } catch (JsonProcessingException e) {
            throw new InvalidDataFormatException("Invalid data format", new Throwable());
        }
        return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.OK);
    }


    private void validateId(String id, String idType) {
        try {
            UUID.fromString(id);
        } catch (IllegalArgumentException ex) {
            throw new InvalidIdentifierException(idType + " - " + id + " is of invalid format", new Throwable());
        }
    }
}
