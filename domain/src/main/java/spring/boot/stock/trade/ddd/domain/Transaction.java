package spring.boot.stock.trade.ddd.domain;

import java.sql.Timestamp;

public class Transaction {
    private final Identifier id;
    private Identifier buyingOrderId;
    private Identifier sellingOrderId;
    private TransactionStatus transactionStatus;
    private Timestamp creationTimestamp;
    private Timestamp completedTimestamp;

    public Transaction(Identifier id) {
        this.id = id;
    }

    public Timestamp getCompletedTimestamp() {
        return completedTimestamp;
    }

    public void setCompletedTimestamp(Timestamp completedTimestamp) {
        this.completedTimestamp = completedTimestamp;
    }

    public Timestamp getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Timestamp creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Identifier getSellingOrderId() {
        return sellingOrderId;
    }

    public void setSellingOrderId(Identifier sellingOrderId) {
        this.sellingOrderId = sellingOrderId;
    }

    public Identifier getBuyingOrderId() {
        return buyingOrderId;
    }

    public void setBuyingOrderId(Identifier buyingOrderId) {
        this.buyingOrderId = buyingOrderId;
    }

    public Identifier getId() {
        return id;
    }


}
