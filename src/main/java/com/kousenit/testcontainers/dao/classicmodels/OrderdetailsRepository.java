package com.kousenit.testcontainers.dao.classicmodels;

import com.kousenit.testcontainers.entities.classicmodels.Orderdetails;
import com.kousenit.testcontainers.entities.classicmodels.OrderdetailsPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderdetailsRepository extends JpaRepository<Orderdetails, OrderdetailsPK> {
    List<Orderdetails> findByProductCode(String productCode);
}
