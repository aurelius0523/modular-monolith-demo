package com.aurelius.modularmonolithdemo.books.respositories.book;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        value = "com.aurelius.modularmonolithdemo.books.respositories.book",
        transactionManagerRef = "bookTransactionManager",
        entityManagerFactoryRef = "bookEntityManagerFactory")
//@EnableJpaRepositories
public class BookRepositoryConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource bookDataSource() {
        return DataSourceBuilder.create().url("jdbc:h2:./test;INIT=SET SCHEMA book").build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(bookDataSource());
        em.setPackagesToScan("com.aurelius.modularmonolithdemo.books.respositories.book");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map map = new HashMap<>();
        map.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        em.setJpaPropertyMap(map);

        return em;
    }

    @Bean
    public PlatformTransactionManager bookTransactionManager() {
        return new JpaTransactionManager(bookEntityManagerFactory().getObject());
    }
}
