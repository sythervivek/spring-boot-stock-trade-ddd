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
@Entity(name = "STOCKS")
@Table(name = "STOCKS")
public class StockEntity {
    @Column(name ="ID")
    private @Id UUID id;

    @Column(name ="STOCKTICKERSYMBOL")
    private String stockTickerSymbol;

    @Column(name ="COMPANYNAME")
    private String companyName;

    @Column(name ="MARKET")
    private String market;

    @Column(name ="SECTOR")
    private String sector;

    @Column(name ="PRICEPERSHARE")
    private BigDecimal pricePerShare;

    @Column(name ="CURRENCYTYPE")
    private String currencyType;
}
