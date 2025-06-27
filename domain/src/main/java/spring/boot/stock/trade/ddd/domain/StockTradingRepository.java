package spring.boot.stock.trade.ddd.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface StockTradingRepository {

    Identifier saveOrder(Order order);

    Optional<Order> findOrderByStock(Identifier stockId, BigDecimal quantity, OrderType orderType);

    Optional<Order> findOrderByOrderId(Identifier id);

    Optional<Portfolio> getUserPortfolio(Identifier userId);

    Identifier savePortfolio(Portfolio portfolio);

    Identifier saveTransaction(Transaction transaction);

    BigDecimal getPricePerStockByStockId(Identifier stockId);

    List<Account> getUserAccountsById(Identifier userId);

    TradingAccount getTradingAccountBalance(TradingAccount tradingAccount);

    CurrentAccount getCurrentAccountBalance(CurrentAccount currentAccount);
}
