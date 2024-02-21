package com.github.etinaa.assignment.players;

import org.junit.ClassRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

@ContextConfiguration(initializers = {BaseIntegrationTest.PostgreSqlInitializer.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseIntegrationTest {

    public static PostgreSQLContainer<?> POSTGRESQL_CONTAINER = new PostgreSQLContainer("postgres:16-alpine")
            .withDatabaseName("test_db_ia")
            .withUsername("sa")
            .withPassword("sa");

    static class PostgreSqlInitializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            POSTGRESQL_CONTAINER.start();
            TestPropertyValues.of(
                    "spring.datasource.url=" + POSTGRESQL_CONTAINER.getJdbcUrl(),
                    "spring.datasource.username=" + POSTGRESQL_CONTAINER.getUsername(),
                    "spring.datasource.password=" + POSTGRESQL_CONTAINER.getPassword()
            ).applyTo(applicationContext.getEnvironment());
            applicationContext.addApplicationListener(
                    (ApplicationListener<ContextClosedEvent>) event -> POSTGRESQL_CONTAINER.stop());
        }
    }
}
