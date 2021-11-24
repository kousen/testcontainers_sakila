package com.kousenit.testcontainers.dao;

import com.kousenit.testcontainers.entities.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class SakilaDBTest {

    @Container
    private static final MySQLContainer<?> database = new MySQLContainer<>("mysql:latest")
            .withDatabaseName("sakila")
            .withUsername("test")
            .withPassword("test")
            .withEnv("MYSQL_ROOT_PASSWORD", "test")
            .withCopyFileToContainer(
                    MountableFile.forClasspathResource("sakila-db/sakila-both.sql"),
                    "/docker-entrypoint-initdb.d/schema.sql"
            )
            .withExposedPorts(3306);

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void shouldBe109countriesInRepository() {
        assertThat(countryRepository.count()).isEqualTo(109);
    }

    @Test
    void citiesInUS() {
        Country usa = countryRepository.findByName("United States");
        System.out.println(usa);
        System.out.println(usa.getName() + " has " +
                usa.getCities().size() + " cities");
        usa.getCities().forEach(city -> System.out.println(city.getName()));
    }

    @DynamicPropertySource
    static void databaseProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", database::getJdbcUrl);
        registry.add("spring.datasource.username", database::getUsername);
        registry.add("spring.datasource.password", database::getPassword);
    }
}
