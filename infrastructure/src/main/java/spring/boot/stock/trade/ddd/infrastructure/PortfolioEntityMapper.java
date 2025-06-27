package spring.boot.stock.trade.ddd.infrastructure;

import org.springframework.stereotype.Component;
import spring.boot.stock.trade.ddd.domain.Identifier;
import spring.boot.stock.trade.ddd.domain.Portfolio;
import spring.boot.stock.trade.ddd.infrastructure.entities.PortfolioEntity;

@Component
public class PortfolioEntityMapper implements EntityMapper<PortfolioEntity, Portfolio>{
    @Override
    public PortfolioEntity convertToEntity(Portfolio domainModel) {
        PortfolioEntity portfolioEntity = new PortfolioEntity();

        portfolioEntity.setId(domainModel.getId().uuid());
        portfolioEntity.setUserId(domainModel.getUserId().uuid());
        portfolioEntity.setCreatedAt(domainModel.getCreatedAt());

        return portfolioEntity;
    }

    @Override
    public Portfolio convertFromEntity(PortfolioEntity entity) {
        Portfolio portfolio = new Portfolio(new Identifier(entity.getId()));

        portfolio.setUserId(new Identifier(entity.getUserId()));
        portfolio.setCreatedAt(entity.getCreatedAt());

        return portfolio;
    }
}
