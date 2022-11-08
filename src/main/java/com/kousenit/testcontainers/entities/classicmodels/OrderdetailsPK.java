package com.kousenit.testcontainers.entities.classicmodels;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class OrderdetailsPK implements Serializable {
    @Column(name = "orderNumber")
    private int orderNumber;

    @Column(name = "productCode")
    private String productCode;

    public OrderdetailsPK() {
    }

    public OrderdetailsPK(int orderNumber, String productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderdetailsPK that = (OrderdetailsPK) o;
        return orderNumber == that.orderNumber && Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode);
    }

    @Override
    public String toString() {
        return "OrderdetailsPK{" +
                "orderNumber=" + orderNumber +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
