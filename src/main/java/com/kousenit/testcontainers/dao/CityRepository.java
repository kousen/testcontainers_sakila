package com.kousenit.testcontainers.dao;

import com.kousenit.testcontainers.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}
