package spring.boot.stock.trade.ddd.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "PORTFOLIOS")
@Entity(name = "PORTFOLIOS")
public class PortfolioEntity {

    @Column(name ="ID")
    private @Id UUID id;

    @Column(name ="USERID")
    private UUID userId;

    @Column(name ="CREATEDAT")
    private Timestamp createdAt;

}
