package com.metacube.demo.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Database and hibernate template configuration class
 * @author Jugal
 * Dated 09/18/2019
 */
@Configuration
@EnableTransactionManagement
public class Config {
	
	// DataSource Bean
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Student");
        dataSource.setUsername("root");
        dataSource.setPassword("rivak");
        return dataSource;
    }

    //EntityManager Bean
    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(false);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaProperties(getHibernateProperties());
        factory.setPackagesToScan("com.metacube.demo.entity");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }


    //JpaTransactionManager Bean
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setDataSource(dataSource());
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    //Setting properties of hibernate
    Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.ddl-auto", "update");
        return properties;
    }
}