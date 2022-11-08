package com.kousenit.testcontainers.entities.classicmodels;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "payments", schema = "classicmodels")
public class Payment {
    @EmbeddedId
    private PaymentPK paymentPK;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "amount")
    private BigDecimal amount;

    public Payment() {
    }

    public Payment(PaymentPK paymentPK, Date paymentDate, BigDecimal amount) {
        this.paymentPK = paymentPK;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentPK, payment.paymentPK) && Objects.equals(paymentDate, payment.paymentDate) && Objects.equals(amount, payment.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentPK, paymentDate, amount);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentPK=" + paymentPK +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                '}';
    }
}
