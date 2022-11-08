package com.kousenit.testcontainers.dao.classicmodels;

import com.kousenit.testcontainers.entities.classicmodels.Payment;
import com.kousenit.testcontainers.entities.classicmodels.PaymentPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, PaymentPK> {
    List<Payment> findAllByPaymentPKCustomerNumber(int customerNumber);
}
