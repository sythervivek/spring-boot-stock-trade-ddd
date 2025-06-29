package spring.boot.stock.trade.ddd.infrastructure.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "TRANSACTIONS")
@Table(name = "TRANSACTIONS")
public class TransactionEntity {
    private @Id UUID id;
    private UUID buyingOrderId;
    private UUID sellingOrderId;
    private String transactionStatus;
    private Timestamp creationTimestamp;
    private Timestamp completedTimestamp;
}
