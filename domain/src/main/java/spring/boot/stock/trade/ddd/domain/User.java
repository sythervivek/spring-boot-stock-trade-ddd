package spring.boot.stock.trade.ddd.domain;


import java.sql.Timestamp;

public class User {

    private Identifier userId;
    private String userName;
    private Email emailId;
    private PasswordHash passwordHash;
    private Timestamp createdAt;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailId(Email emailId) {
        this.emailId = emailId;
    }

    public void setPasswordHash(PasswordHash passwordHash) {
        this.passwordHash = passwordHash;
    }

    public PasswordHash getPasswordHash() {
        return passwordHash;
    }

    public Identifier getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Email getEmailId() {
        return emailId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

}
