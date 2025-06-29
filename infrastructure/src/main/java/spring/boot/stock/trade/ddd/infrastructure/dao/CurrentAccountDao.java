package spring.boot.stock.trade.ddd.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.boot.stock.trade.ddd.infrastructure.entities.CurrentAccountBalanceEntity;
import spring.boot.stock.trade.ddd.infrastructure.entities.CurrentAccountEntity;

import java.util.List;
import java.util.UUID;

public interface CurrentAccountDao extends JpaRepository<CurrentAccountEntity, String> {

    @Query("Select c from CURRENT_ACCOUNT c where c.accountHolderId = :userId")
    CurrentAccountEntity findCurrentAccountOfUser(@Param("userId") UUID userId);

    @Query("Select cb from CURRENT_ACCOUNT_BALANCE cb where cb.accountNumber = :accountNumber")
    CurrentAccountBalanceEntity findCurrentAccountBalanceByAccountNumber(@Param("accountNumber") String accountNumber);
}
