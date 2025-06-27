package spring.boot.stock.trade.ddd.infrastructure;

import org.springframework.stereotype.Component;
import spring.boot.stock.trade.ddd.domain.*;
import spring.boot.stock.trade.ddd.infrastructure.entities.CurrentAccountEntity;

@Component
public class CurrentAccountEntityMapper implements EntityMapper<CurrentAccountEntity, CurrentAccount> {
    @Override
    public CurrentAccountEntity convertToEntity(CurrentAccount domainModel) {
        CurrentAccountEntity currentAccountEntity = new CurrentAccountEntity();

        currentAccountEntity.setAccountHolderId(domainModel.getAccountHolderId().uuid());
        currentAccountEntity.setAccountNumber(domainModel.getAccountNumber().accountNumber());
        currentAccountEntity.setAccountType(domainModel.getAccountType().name());

        return currentAccountEntity;
    }

    @Override
    public CurrentAccount convertFromEntity(CurrentAccountEntity entity) {
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setAccountNumber(new AccountNumber(entity.getAccountNumber()));
        currentAccount.setAccountHolderId(new Identifier(entity.getAccountHolderId()));
        currentAccount.setAccountType(AccountType.valueOf(entity.getAccountType()));
        return currentAccount;
    }
}
