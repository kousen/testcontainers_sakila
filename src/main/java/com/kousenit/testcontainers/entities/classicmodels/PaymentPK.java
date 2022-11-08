package com.kousenit.testcontainers.entities.classicmodels;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PaymentPK implements Serializable {
    @Column(name = "customerNumber")
    private int customerNumber;

    @Column(name = "checkNumber")
    private String checkNumber;

    public PaymentPK() {
    }

    public PaymentPK(int customerNumber, String checkNumber) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentPK that = (PaymentPK) o;
        return customerNumber == that.customerNumber &&
                Objects.equals(checkNumber, that.checkNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, checkNumber);
    }

    @Override
    public String toString() {
        return "PaymentPK{" +
                "customerNumber=" + customerNumber +
                ", checkNumber='" + checkNumber + '\'' +
                '}';
    }
}
