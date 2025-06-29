package spring.boot.stock.trade.ddd.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"spring.boot.stock.trade.ddd.infrastructure", "spring.boot.stock.trade.ddd.application"})
@EntityScan("spring.boot.stock.trade.ddd.infrastructure.entities")
@EnableJpaRepositories("spring.boot.stock.trade.ddd.infrastructure.dao")
public class StockTradingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockTradingApplication.class, args);
    }
}
