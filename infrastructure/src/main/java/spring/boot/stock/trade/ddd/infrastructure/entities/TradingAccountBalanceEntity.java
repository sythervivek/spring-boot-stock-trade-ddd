package spring.boot.stock.trade.ddd.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "TRADING_ACCOUNT_BALANCE")
@Table(name = "TRADING_ACCOUNT_BALANCE")
public class TradingAccountBalanceEntity {

    @Column(name ="ACCOUNTNUMBER")
    private @Id String accountNumber;

    @Column(name ="STOCKID")
    private UUID stockId;

    @Column(name ="QUANTITY")
    private BigDecimal quantity;
}
