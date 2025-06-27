package spring.boot.stock.trade.ddd.infrastructure;

import org.springframework.stereotype.Component;
import spring.boot.stock.trade.ddd.domain.*;
import spring.boot.stock.trade.ddd.infrastructure.dao.*;
import spring.boot.stock.trade.ddd.infrastructure.entities.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class StockTradingRepositoryImpl implements StockTradingRepository {

    private final OrderDao orderDao;
    private final StockDao stockDao;
    private final PortfolioDao portfolioDao;
    private final TradingAccountDao tradingAccountDao;
    private final CurrentAccountDao currentAccountDao;

    private final OrderEntityMapper orderEntityMapper;
    private final PortfolioEntityMapper portfolioEntityMapper;
    private final TradingAccountEntityMapper tradingAccountEntityMapper;
    private final CurrentAccountEntityMapper currentAccountEntityMapper;

    public StockTradingRepositoryImpl(OrderDao orderDao, StockDao stockDao, PortfolioDao portfolioDao, TradingAccountDao tradingAccountDao, CurrentAccountDao currentAccountDao, PortfolioEntityMapper portfolioEntityMapper, TradingAccountEntityMapper tradingAccountEntityMapper, CurrentAccountEntityMapper currentAccountEntityMapper, OrderEntityMapper orderEntityMapper) {
        this.orderDao = orderDao;
        this.stockDao = stockDao;
        this.portfolioDao = portfolioDao;
        this.tradingAccountDao = tradingAccountDao;
        this.currentAccountDao = currentAccountDao;
        this.portfolioEntityMapper = portfolioEntityMapper;
        this.tradingAccountEntityMapper = tradingAccountEntityMapper;
        this.currentAccountEntityMapper = currentAccountEntityMapper;
        this.orderEntityMapper = orderEntityMapper ;
    }


    @Override
    public Identifier saveOrder(Order order) {
        OrderEntity orderEntity = orderEntityMapper.convertToEntity(order);
        return new Identifier(orderDao.save(orderEntity).getId());
    }

    @Override
    public Optional<Order> findOrderByStock(Identifier stockId, BigDecimal quantity, OrderType orderType) {
        OrderEntity orderEntity = orderDao.findByStockIdQuantityAndOrderType(stockId.uuid(), quantity, orderType.name());
        return Optional.of(orderEntityMapper.convertFromEntity(orderEntity));
    }

    @Override
    public Optional<Order> findOrderByOrderId(Identifier id) {
        OrderEntity orderEntity = orderDao.findById(id.uuid()).orElseThrow();
        Order order = orderEntityMapper.convertFromEntity(orderEntity);

        return Optional.of(order);
    }

    @Override
    public Optional<Portfolio> getUserPortfolio(Identifier userId) {
        PortfolioEntity portfolioEntity = portfolioDao.findPortfolioByUserId(userId.uuid()).orElseThrow();
        return Optional.of(portfolioEntityMapper.convertFromEntity(portfolioEntity));
    }

    @Override
    public Identifier savePortfolio(Portfolio portfolio) {
        PortfolioEntity entity = portfolioDao.save(portfolioEntityMapper.convertToEntity(portfolio));
        return new Identifier(entity.getId());
    }

    @Override
    public Identifier saveTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public BigDecimal getPricePerStockByStockId(Identifier stockId) {
        return stockDao.findPricePerStockById(stockId.uuid());
    }

    @Override
    public List<Account> getUserAccountsById(Identifier userId) {
        List<Account> combinedUserAccounts = new java.util.ArrayList<>(List.of());
        TradingAccount tradingAccount = tradingAccountEntityMapper.convertFromEntity(tradingAccountDao.findTradingAccountOfUser(userId.uuid()));
        CurrentAccount currentAccount = currentAccountEntityMapper.convertFromEntity(currentAccountDao.findCurrentAccountOfUser(userId.uuid()));

        combinedUserAccounts.add(currentAccount);
        combinedUserAccounts.add(tradingAccount);

        return combinedUserAccounts;
    }

    @Override
    public TradingAccount getTradingAccountBalance(TradingAccount tradingAccount) {
        List<TradingAccountBalanceEntity> tradingAccountBalanceEntities = tradingAccountDao.findTradingAccountBalanceByAccountNumber(tradingAccount.getAccountNumber().accountNumber());

        tradingAccountBalanceEntities.forEach(entity ->tradingAccount.getStockData().put(new Identifier(entity.getStockId()), entity.getQuantity()));
        return tradingAccount;
    }

    @Override
    public CurrentAccount getCurrentAccountBalance(CurrentAccount currentAccount) {
        CurrentAccountBalanceEntity currentAccountBalanceEntity = currentAccountDao.findCurrentAccountBalanceByAccountNumber(currentAccount.getAccountNumber().accountNumber());
        currentAccount.setAmount(currentAccountBalanceEntity.getAmount());

        return currentAccount;
    }


}
