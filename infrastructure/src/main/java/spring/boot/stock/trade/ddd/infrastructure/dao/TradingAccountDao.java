package spring.boot.stock.trade.ddd.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.boot.stock.trade.ddd.infrastructure.entities.TradingAccountBalanceEntity;
import spring.boot.stock.trade.ddd.infrastructure.entities.TradingAccountEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface TradingAccountDao extends JpaRepository<TradingAccountEntity, String> {

    @Query("Select t from TRADING_ACCOUNT t where t.accountHolderId = :userId")
    TradingAccountEntity findTradingAccountOfUser(@Param("userId") UUID userId);

    @Query("Select tb from TRADING_ACCOUNT_BALANCE tb where tb.accountNumber = :accountNumber")
    List<TradingAccountBalanceEntity> findTradingAccountBalanceByAccountNumber(@Param("accountNumber") String accountNumber);
}
