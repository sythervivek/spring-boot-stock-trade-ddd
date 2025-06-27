package spring.boot.stock.trade.ddd.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "CURRENT_ACCOUNT")
@Table(name = "CURRENT_ACCOUNT")
public class CurrentAccountEntity {


    @Column(name ="ACCOUNTNUMBER")
    private @Id String accountNumber;

    @Column(name ="USERID")
    private UUID accountHolderId;

    @Column(name ="ACCOUNTTYPE")
    private String accountType;
}
