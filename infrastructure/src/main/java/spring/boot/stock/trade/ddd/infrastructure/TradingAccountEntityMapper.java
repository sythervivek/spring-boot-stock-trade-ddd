package spring.boot.stock.trade.ddd.infrastructure;

import org.springframework.stereotype.Component;
import spring.boot.stock.trade.ddd.domain.AccountNumber;
import spring.boot.stock.trade.ddd.domain.AccountType;
import spring.boot.stock.trade.ddd.domain.Identifier;
import spring.boot.stock.trade.ddd.domain.TradingAccount;
import spring.boot.stock.trade.ddd.infrastructure.entities.TradingAccountEntity;

@Component
public class TradingAccountEntityMapper implements EntityMapper<TradingAccountEntity, TradingAccount> {
    @Override
    public TradingAccountEntity convertToEntity(TradingAccount domainModel) {
        TradingAccountEntity tradingAccountEntity = new TradingAccountEntity();

        tradingAccountEntity.setAccountHolderId(domainModel.getAccountHolderId().uuid());
        tradingAccountEntity.setAccountNumber(domainModel.getAccountNumber().accountNumber());
        tradingAccountEntity.setAccountType(domainModel.getAccountType().name());

        return tradingAccountEntity;
    }

    @Override
    public TradingAccount convertFromEntity(TradingAccountEntity entity) {
        TradingAccount tradingAccount = new TradingAccount();
        tradingAccount.setAccountNumber(new AccountNumber(entity.getAccountNumber()));
        tradingAccount.setAccountHolderId(new Identifier(entity.getAccountHolderId()));
        tradingAccount.setAccountType(AccountType.valueOf(entity.getAccountType()));
        return tradingAccount;
    }
}
