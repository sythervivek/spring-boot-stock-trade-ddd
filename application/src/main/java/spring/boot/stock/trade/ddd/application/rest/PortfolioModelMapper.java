package spring.boot.stock.trade.ddd.application.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Component;
import spring.boot.stock.trade.ddd.domain.Portfolio;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class PortfolioModelMapper implements ModelMapper<PortfolioRequest, PortfolioResponse, Portfolio>{

    @Override
    public PortfolioResponse convertToModel(Portfolio domainModel) throws JsonProcessingException {
        PortfolioResponse response = new PortfolioResponse();

        ObjectMapper objectMapper = new ObjectMapper();
        response.setId(domainModel.getId().uuid().toString());
        response.setCreatedAt(domainModel.getCreatedAt());
        response.setTotalValue(domainModel.getTotalValue());
        response.setUserId(domainModel.getUserId().uuid().toString());

        Map<String, BigDecimal> responseStocksMap = new java.util.HashMap<>(Map.of());
        domainModel.getStocksInUserPortFolio().forEach((stockId, stockQuantity) -> responseStocksMap.put(stockId.uuid().toString(), stockQuantity));
        response.setStocksInUserPortFolio(objectMapper.writeValueAsString(responseStocksMap));
        return response;
    }

    @Override
    public Portfolio convertFromModel(PortfolioRequest entity) {
        //TODO Implement this method when required
        return null;
    }
}
