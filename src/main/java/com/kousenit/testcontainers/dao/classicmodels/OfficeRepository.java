package com.kousenit.testcontainers.dao.classicmodels;

import com.kousenit.testcontainers.entities.classicmodels.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, String> {
}
