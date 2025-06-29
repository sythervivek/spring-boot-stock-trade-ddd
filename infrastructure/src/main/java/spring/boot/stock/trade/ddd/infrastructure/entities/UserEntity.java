package spring.boot.stock.trade.ddd.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "USERS")
@Table(name = "USERS")
public class UserEntity {
    private @Id UUID id;
    private String userName;
    private String emailId;
    private String passwordHash;
    private Timestamp createdAt;
}
