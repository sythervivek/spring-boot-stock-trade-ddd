package spring.boot.stock.trade.ddd.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity (name = "ORDERS")
@Table(name = "ORDERS")
public class OrderEntity {

    @Column(name ="ID")
    private @Id UUID id;

    @Column(name ="USERID")
    private UUID userId;

    @Column(name ="STOCKID")
    private UUID stockId;

    @Column(name ="QUANTITY")
    private BigDecimal quantity;

    @Column(name ="ORDERTYPE")
    private String orderType;

    @Column(name ="PRICEPERSHARE")
    private BigDecimal pricePerShare;

    @Column(name ="ORDERSTATUS")
    private String orderStatus;

    @Column(name ="CREATEDTIMESTAMP")
    private Timestamp createdTimestamp;
}
