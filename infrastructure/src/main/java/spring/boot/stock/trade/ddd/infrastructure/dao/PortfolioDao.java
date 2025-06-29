package spring.boot.stock.trade.ddd.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.boot.stock.trade.ddd.infrastructure.entities.PortfolioEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PortfolioDao extends JpaRepository<PortfolioEntity, UUID> {

    @Query("Select p from PORTFOLIOS p where p.userId = :userId")
    Optional<PortfolioEntity> findPortfolioByUserId(@Param("userId") UUID userId);
}
