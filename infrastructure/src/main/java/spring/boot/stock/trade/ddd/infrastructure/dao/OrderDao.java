package spring.boot.stock.trade.ddd.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.boot.stock.trade.ddd.infrastructure.entities.OrderEntity;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity, UUID> {

    @Query("Select o from ORDERS o where o.stockId = :stockId and o.quantity = :quantity and o.orderType = :orderType")
    OrderEntity findByStockIdQuantityAndOrderType(@Param("stockId") UUID stockId, @Param("quantity") BigDecimal quantity, @Param("orderType") String orderType);

}
