package dto;

import domein.AccountType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;
import java.util.UUID;

public class AccountCreateDTO {
    private UUID accountId;

    private Integer accountNum;

    private AccountType type;

    private double balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountCreateDTO that = (AccountCreateDTO) o;
        return Double.compare(that.balance, balance) == 0 &&
                accountId.equals(that.accountId) &&
                accountNum.equals(that.accountNum) &&
                type == that.type;
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
