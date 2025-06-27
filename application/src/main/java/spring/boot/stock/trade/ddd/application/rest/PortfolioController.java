package spring.boot.stock.trade.ddd.application.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.stock.trade.ddd.application.exceptions.InvalidIdentifierException;
import spring.boot.stock.trade.ddd.application.exceptions.InvalidDataFormatException;
import spring.boot.stock.trade.ddd.application.exceptions.PortfolioNotFoundException;
import spring.boot.stock.trade.ddd.application.services.PortfolioApplicationService;
import spring.boot.stock.trade.ddd.domain.Identifier;
import spring.boot.stock.trade.ddd.domain.Portfolio;

import java.util.UUID;

@RestController
@RequestMapping("/v1/portfolios")
public class PortfolioController {

    private final PortfolioApplicationService portfolioApplicationService;
    private final ModelMapper<PortfolioRequest, PortfolioResponse, Portfolio> portfolioModelMapper;

    public PortfolioController(PortfolioApplicationService portfolioApplicationService,
                               ModelMapper<PortfolioRequest, PortfolioResponse, Portfolio> portfolioModelMapper) {
        this.portfolioApplicationService = portfolioApplicationService;
        this.portfolioModelMapper = portfolioModelMapper;
    }

    @PostMapping("/portfolio")
    public String createPortfolioOfUser(@RequestBody PortfolioRequest request) {
        validateId(request.getUserId(), "UserId");
        return portfolioApplicationService.createUserPortfolio(new Identifier(UUID.fromString(request.getUserId())));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<PortfolioResponse> getUserPortfolio(@PathVariable("userId") String userId) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        validateId(userId, "UserId");
        Portfolio portfolio = portfolioApplicationService.getPortFolioOfUser(new Identifier(UUID.fromString(userId)));
        if (portfolio == null) {
            throw new PortfolioNotFoundException("Portfolio Not Found", new Throwable());
        }

        try {
            portfolioResponse = portfolioModelMapper.convertToModel(portfolio);
        } catch (JsonProcessingException e) {
            throw new InvalidDataFormatException("Portfolio Data is in invalid format", new Throwable());
        }

        return new ResponseEntity<PortfolioResponse>(portfolioResponse, HttpStatus.OK);
    }

    private void validateId(String id, String idType) {
        try {
            UUID.fromString(id);
        } catch (IllegalArgumentException ex) {
            throw new InvalidIdentifierException(idType + " - " + id + " is of invalid format", new Throwable());
        }
    }
}
