package spring.boot.stock.trade.ddd.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.boot.stock.trade.ddd.domain.StockTradingRepository;
import spring.boot.stock.trade.ddd.domain.services.OrderService;
import spring.boot.stock.trade.ddd.domain.services.PortfolioService;

@Configuration(proxyBeanMethods=false)
public class BeanConfigurationClass {

    @Bean
    OrderService orderService(StockTradingRepository stockTradingRepository) {
        return new OrderService(stockTradingRepository);
    }

    @Bean
    PortfolioService portfolioService(StockTradingRepository stockTradingRepository) {
        return new PortfolioService(stockTradingRepository);
    }

}
