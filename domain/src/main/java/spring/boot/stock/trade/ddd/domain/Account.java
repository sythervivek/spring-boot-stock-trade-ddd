package spring.boot.stock.trade.ddd.domain;

public abstract class Account {
    private AccountNumber accountNumber;
    private Identifier accountHolderId;
    private AccountType accountType;

    public Identifier getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(Identifier accountHolderId) {
        this.accountHolderId = accountHolderId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }
}
