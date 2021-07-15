package dto;

import domein.Account;
import domein.Client;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.OneToOne;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class PaymentCreateDTO {
    private UUID paymentId;

    private String status;

    private Double amount;


    private Account srcAccId;

    private Account dstAccId;

    private Client payer;

    private Client recipient;

    private Instant createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentCreateDTO that = (PaymentCreateDTO) o;
        return paymentId.equals(that.paymentId) &&
                status.equals(that.status) &&
                amount.equals(that.amount) &&
                srcAccId.equals(that.srcAccId) &&
                dstAccId.equals(that.dstAccId) &&
                payer.equals(that.payer) &&
                recipient.equals(that.recipient) &&
                createdAt.equals(that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, status, amount, srcAccId, dstAccId, payer, recipient, createdAt);
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getSrcAccId() {
        return srcAccId;
    }

    public void setSrcAccId(Account srcAccId) {
        this.srcAccId = srcAccId;
    }

    public Account getDstAccId() {
        return dstAccId;
    }

    public void setDstAccId(Account dstAccId) {
        this.dstAccId = dstAccId;
    }

    public Client getPayer() {
        return payer;
    }

    public void setPayer(Client payer) {
        this.payer = payer;
    }

    public Client getRecipient() {
        return recipient;
    }

    public void setRecipient(Client recipient) {
        this.recipient = recipient;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
