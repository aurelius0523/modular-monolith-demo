package com.aurelius.modularmonolithdemo.books.repositories.book;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        value = "com.aurelius.modularmonolithdemo.books.repositories.book",
        transactionManagerRef = "bookTransactionManager",
        entityManagerFactoryRef = "bookEntityManagerFactory")
public class BookRepositoryConfig {
    @Bean
    public DataSource bookDataSource() {
        DataSource dataSource = DataSourceBuilder.create()
                .url("jdbc:h2:mem:modular;INIT=CREATE SCHEMA IF NOT EXISTS book\\;SET SCHEMA book")
                .build();

        Resource initData = new ClassPathResource("scripts/book.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initData);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(bookDataSource());
        em.setPackagesToScan("com.aurelius.modularmonolithdemo.books.repositories.book");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, String> propertyToValueMap = new HashMap<>();
        propertyToValueMap.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        em.setJpaPropertyMap(propertyToValueMap);

        return em;
    }

    @Bean
    public PlatformTransactionManager bookTransactionManager() {
        return new JpaTransactionManager(bookEntityManagerFactory().getObject());
    }
}
