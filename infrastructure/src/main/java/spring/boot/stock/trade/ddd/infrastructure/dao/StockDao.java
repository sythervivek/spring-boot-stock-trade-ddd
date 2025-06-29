package spring.boot.stock.trade.ddd.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.boot.stock.trade.ddd.infrastructure.entities.StockEntity;

import java.math.BigDecimal;
import java.util.UUID;

public interface StockDao extends JpaRepository<StockEntity, UUID> {

    @Query("Select s.pricePerShare from STOCKS s where s.id = :stockId")
    BigDecimal findPricePerStockById(@Param("stockId") UUID stockId);
}
