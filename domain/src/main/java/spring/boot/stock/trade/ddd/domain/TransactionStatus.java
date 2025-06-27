package spring.boot.stock.trade.ddd.domain;

public enum TransactionStatus {
    INITIATED,
    STOCKS_CREDITED_TO_BUYER,
    STOCKS_DEBITED_FROM_SELLER,
    AMOUNT_CREDITED_TO_SELLER,
    AMOUNT_DEBITED_FROM_BUYER,
    COMPLETED,
    FAILED,
    ABORTED;
}
