package spring.boot.stock.trade.ddd.domain.services;

import spring.boot.stock.trade.ddd.domain.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class PortfolioService {
    private final StockTradingRepository stockTradingRepository;

    public PortfolioService(StockTradingRepository stockTradingRepository) {
        this.stockTradingRepository = stockTradingRepository;
    }

    public String createUserPortfolio(Identifier userId) {
        Portfolio newPortfolio = new Portfolio(new Identifier(UUID.randomUUID()));
        newPortfolio.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        newPortfolio.setUserId(userId);

        return stockTradingRepository.savePortfolio(newPortfolio).uuid().toString();
    }

    public Portfolio getUserPortfolio(Identifier userId) {
        Portfolio portfolio = stockTradingRepository.getUserPortfolio(userId).orElseThrow();
        List<Account> combinedUserAccounts = stockTradingRepository.getUserAccountsById(userId);

        combinedUserAccounts.forEach(account -> {
            switch (account) {
                case TradingAccount tradingAccount -> {
                    stockTradingRepository.getTradingAccountBalance(tradingAccount);
                    portfolio.getStocksInUserPortFolio().putAll(tradingAccount.getStockData());
                }
                case CurrentAccount currentAccount -> {
                    stockTradingRepository.getCurrentAccountBalance(currentAccount);
                    portfolio.setTotalValue(currentAccount.getAmount());
                }
                default -> throw new IllegalStateException("Unexpected value: " + account);
            }
        });
        return portfolio;
    }
}
