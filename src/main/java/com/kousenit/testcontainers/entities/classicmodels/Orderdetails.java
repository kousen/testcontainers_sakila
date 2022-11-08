package com.kousenit.testcontainers.entities.classicmodels;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "orderdetails", schema = "classicmodels")
@IdClass(OrderdetailsPK.class)
public class Orderdetails {
    @Id
    @Column(name = "orderNumber")
    private int orderNumber;

    @Id
    @Column(name = "productCode")
    private String productCode;

    @Column(name = "quantityOrdered")
    private int quantityOrdered;

    @Column(name = "priceEach")
    private BigDecimal priceEach;

    @Column(name = "orderLineNumber")
    private short orderLineNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderdetails that = (Orderdetails) o;
        return orderNumber == that.orderNumber && quantityOrdered == that.quantityOrdered && orderLineNumber == that.orderLineNumber && Objects.equals(productCode, that.productCode) && Objects.equals(priceEach, that.priceEach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber);
    }

    @Override
    public String toString() {
        return "Orderdetails{" +
                "orderNumber=" + orderNumber +
                ", productCode='" + productCode + '\'' +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                '}';
    }
}
