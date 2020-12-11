package com.github.pwnmn.config;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Slf4j
@TestConfiguration
public class FlywayConfig {

    @Autowired
    private DataSource datasource;

    @PostConstruct
    public void migrate() {
        log.debug("Starting flyway test migration...");
        Flyway migration = Flyway.configure()
                .schemas("public")
                .locations("db/migration")
                .dataSource(datasource).load();

        migration.clean();
        migration.migrate();
    }
}
