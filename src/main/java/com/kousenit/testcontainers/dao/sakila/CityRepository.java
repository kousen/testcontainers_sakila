package com.kousenit.testcontainers.dao.sakila;

import com.kousenit.testcontainers.entities.sakila.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}
