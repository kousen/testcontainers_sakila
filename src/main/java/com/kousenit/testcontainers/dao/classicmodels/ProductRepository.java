package com.kousenit.testcontainers.dao.classicmodels;

import com.kousenit.testcontainers.entities.classicmodels.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
