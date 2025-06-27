package spring.boot.stock.trade.ddd.application.services;

import org.springframework.stereotype.Service;
import spring.boot.stock.trade.ddd.domain.Identifier;
import spring.boot.stock.trade.ddd.domain.Portfolio;
import spring.boot.stock.trade.ddd.domain.services.PortfolioService;

@Service
public class PortfolioApplicationService {

    private final PortfolioService portfolioService;


    public PortfolioApplicationService(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    public String createUserPortfolio(Identifier userId) {
        return portfolioService.createUserPortfolio(userId);
    }

    public Portfolio getPortFolioOfUser(Identifier userId) {
        return portfolioService.getUserPortfolio(userId);
    }
}
