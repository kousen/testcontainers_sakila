package com.kousenit.testcontainers.dao;

import com.kousenit.testcontainers.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
    Country findByName(String australia);
}
