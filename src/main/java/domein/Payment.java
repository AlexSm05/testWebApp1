package domein;

import org.springframework.data.annotation.CreatedDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private UUID paymentId;

    private String status;

    private Double amount;

    @OneToOne
    private Account srcAccId;
    @OneToOne
    private Account dstAccId;
    @OneToOne
    private Client payer;
    @OneToOne
    private Client recipient;
    @CreatedDate
    private Instant createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Payment payment = (Payment) o;
        return paymentId.equals(payment.paymentId) &&
                status.equals(payment.status) &&
                amount.equals(payment.amount) &&
                srcAccId.equals(payment.srcAccId) &&
                dstAccId.equals(payment.dstAccId) &&
                payer.equals(payment.payer) &&
                recipient.equals(payment.recipient) &&
                createdAt.equals(payment.createdAt);
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
