package com.fullhouse.studentmanagerment.configs;


import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {
    @Autowired
    DataSource dataSource;
    @Bean(initMethod = "migrate")
    Flyway flyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .outOfOrder(true)  // Enable out of order migrations
                .load();

//        flyway.migrate();
        return flyway;
    }
}
