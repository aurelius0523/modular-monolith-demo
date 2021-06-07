package com.aurelius.modularmonolithdemo.authors.repositories.author;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.aurelius.modularmonolithdemo.authors.repositories.author")
public class AuthorRepositoryConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.author.datasource")
    public DataSource authorDataSource() {
        DriverManagerDataSource authorDataSource = new DriverManagerDataSource();
        authorDataSource.setDriverClassName("org.h2.Driver");
        authorDataSource.setUsername("modular");
        authorDataSource.setPassword("modular");
        authorDataSource.setUrl("jdbc:h2:./test;INIT=CREATE SCHEMA IF NOT EXISTS author\\;SET SCHEMA author");

        return authorDataSource;
    }
}
