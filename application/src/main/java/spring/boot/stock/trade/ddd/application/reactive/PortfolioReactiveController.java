package spring.boot.stock.trade.ddd.application.reactive;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import spring.boot.stock.trade.ddd.application.exceptions.InvalidDataFormatException;
import spring.boot.stock.trade.ddd.application.exceptions.InvalidIdentifierException;
import spring.boot.stock.trade.ddd.application.exceptions.PortfolioNotFoundException;
import spring.boot.stock.trade.ddd.application.rest.ModelMapper;
import spring.boot.stock.trade.ddd.application.rest.PortfolioRequest;
import spring.boot.stock.trade.ddd.application.rest.PortfolioResponse;
import spring.boot.stock.trade.ddd.application.services.PortfolioApplicationService;
import spring.boot.stock.trade.ddd.domain.Identifier;
import spring.boot.stock.trade.ddd.domain.Portfolio;

import java.util.UUID;

@RestController
@RequestMapping("/v2/portfolios")
public class PortfolioReactiveController {

    private final PortfolioApplicationService portfolioApplicationService;
    private final ModelMapper<PortfolioRequest, PortfolioResponse, Portfolio> portfolioModelMapper;

    public PortfolioReactiveController(PortfolioApplicationService portfolioApplicationService,
                                       ModelMapper<PortfolioRequest, PortfolioResponse, Portfolio> portfolioModelMapper) {
        this.portfolioApplicationService = portfolioApplicationService;
        this.portfolioModelMapper = portfolioModelMapper;
    }

    @PostMapping("/portfolio")
    public Mono<String> createPortfolioOfUser(@RequestBody PortfolioRequest request) {
        validateId(request.getUserId(), "UserId");
        return Mono.just(portfolioApplicationService.createUserPortfolio(new Identifier(UUID.fromString(request.getUserId()))));
    }

    @GetMapping("/{userId}")
    public Mono<PortfolioResponse> getUserPortfolio(@PathVariable("userId") String userId) {
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

        return Mono.just(portfolioResponse);
    }

    private void validateId(String id, String idType) {
        try {
            UUID.fromString(id);
        } catch (IllegalArgumentException ex) {
            throw new InvalidIdentifierException(idType + " - " + id + " is of invalid format", new Throwable());
        }
    }
}
