package com.kousenit.testcontainers.dao.sakila;

import com.kousenit.testcontainers.entities.sakila.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
    Country findByName(String australia);
}
