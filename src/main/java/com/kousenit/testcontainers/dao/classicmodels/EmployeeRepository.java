package com.kousenit.testcontainers.dao.classicmodels;

import com.kousenit.testcontainers.entities.classicmodels.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
