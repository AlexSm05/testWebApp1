package domein;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private UUID accountId;

    private Integer accountNum;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private double balance;

    public Account(UUID accountId, Integer accountNum, AccountType type, double balance) {
        this.accountId = accountId;
        this.accountNum = accountNum;
        this.type = type;
        this.balance = balance;
    }

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 &&
                accountId.equals(account.accountId) &&
                accountNum.equals(account.accountNum) &&
                type == account.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNum, type, balance);
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Integer accountNum) {
        this.accountNum = accountNum;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
