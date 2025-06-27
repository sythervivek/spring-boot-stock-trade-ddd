package spring.boot.stock.trade.ddd.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "CURRENT_ACCOUNT_BALANCE")
@Table(name = "CURRENT_ACCOUNT_BALANCE")
public class CurrentAccountBalanceEntity {

    @Column(name ="ACCOUNTNUMBER")
    private @Id String accountNumber;

    @Column(name ="AMOUNT")
    private BigDecimal amount;
}
