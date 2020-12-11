package com.github.pwnmn.repository;

import com.github.pwnmn.config.FlywayConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import(FlywayConfig.class)
@Testcontainers
@ContextConfiguration(initializers = ThingsRepositoryTest.Initializer.class)
@Sql("/db-dataset/init.sql")
public class ThingsRepositoryTest {

    @Container
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>();

    static class Initializer implements
            ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext context) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgresContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgresContainer.getUsername(),
                    "spring.datasource.password=" + postgresContainer.getPassword()
            )
                    .applyTo(context.getEnvironment());
        }
    }

    @Autowired
    private ThingsRepository thingsRepo;

    @Test
    public void fetchThings_successfullyRetrieved() {
        List<ThingEntity> things = thingsRepo.findAll();
        assertEquals(3, things.size());

        var thing1 = thingsRepo.findByName("thing1");
        assertTrue(thing1.isPresent());
        assertEquals("red", thing1.get().getColor());

        var thing2 = thingsRepo.findByName("thing2");
        assertTrue(thing2.isPresent());
        assertEquals("blue", thing2.get().getColor());

        var thing3 = thingsRepo.findByName("thing3");
        assertTrue(thing3.isPresent());
        assertEquals("green", thing3.get().getColor());

    }
}
