package com.aurelius.modularmonolithdemo.authors.repositories.author;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        value = "com.aurelius.modularmonolithdemo.authors.repositories.author",
        transactionManagerRef = "authorTransactionManager",
        entityManagerFactoryRef = "authorEntityManagerFactory")
public class AuthorRepositoryConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource authorDataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:h2:./test;INIT=SET SCHEMA author")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean authorEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(authorDataSource());
        em.setPackagesToScan("com.aurelius.modularmonolithdemo.authors.repositories.author.entities");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map map = new HashMap<>();
        map.put("hiberna.dialect", "org.hibernate.dialect.H2Dialect");
        em.setJpaPropertyMap(map);
        return em;
    }

    @Bean
    public PlatformTransactionManager authorTransactionManager() {
        return new JpaTransactionManager(authorEntityManagerFactory().getObject());
    }
}
