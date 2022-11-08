package com.kousenit.testcontainers.dao.classicmodels;

import com.kousenit.testcontainers.dao.classicmodels.OrderdetailsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("resource")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class OrderdetailsRepositoryTest {
    @Autowired
    private OrderdetailsRepository orderdetailsRepository;

    @Container
    static MySQLContainer<?> database = new MySQLContainer<>("mysql:latest")
            .withDatabaseName("classicmodels")
            .withUsername("root")
            .withPassword("")
            .withEnv("MYSQL_ROOT_PASSWORD", "")
            .withCopyFileToContainer(
                    MountableFile.forClasspathResource("mysqlsampledatabase.sql"),
                    "/docker-entrypoint-initdb.d/schema.sql"
            )
            .withExposedPorts(3306);

    @Test
    void countOrderdetails() {
        assertEquals(2996, orderdetailsRepository.count());
    }

    @Test
    void findByProductCode() {
        assertThat(orderdetailsRepository.findByProductCode("S18_3232"))
                .hasSize(53);
    }

    @DynamicPropertySource
    static void databaseProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", database::getJdbcUrl);
        registry.add("spring.datasource.username", database::getUsername);
        registry.add("spring.datasource.password", database::getPassword);
    }
}