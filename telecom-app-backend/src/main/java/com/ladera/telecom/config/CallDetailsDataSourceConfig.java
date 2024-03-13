package com.ladera.telecom.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "callDetailsEntityManagerFactory",
        transactionManagerRef = "callDetailsTransactionManager",
        basePackages = {
                "com.ladera.telecom.repository.calldetailsrepository"
        }
)
public class CallDetailsDataSourceConfig {

    @Bean(name="callDetailsDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.calldetailsdb.datasource")
    public DataSource callDetailsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "callDetailsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean callDetailsEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                              @Qualifier("callDetailsDataSource") DataSource callDetailsDataSource) {
        return builder
                .dataSource(callDetailsDataSource)
                .packages("com.ladera.telecom.model")
                .build();
    }

    @Bean(name = "callDetailsTransactionManager")
    public PlatformTransactionManager callDetailsTransactionManager(
            @Qualifier("callDetailsEntityManagerFactory") EntityManagerFactory callDetailsEntityManagerFactory) {
        return new JpaTransactionManager(callDetailsEntityManagerFactory);
    }

}