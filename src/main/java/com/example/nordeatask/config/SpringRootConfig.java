package com.example.nordeatask.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

//import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@ComponentScan({ "com.example" })
@Configuration
@EnableBatchProcessing
public class SpringRootConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @PostConstruct
    public void startDBManager() {

        //hsqldb
//        DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });

    }


}
