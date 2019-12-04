package it.evolvere.progetto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "it.evolvere.progetto.repository")
@EntityScan("it.evolvere.progetto.model")
public class SpringJpaConfig {

    @Autowired
    private Environment env;



    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    @Primary
    public DataSource serviceDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driver"));
        dataSource.setUrl(env.getProperty("jdbcUrl"));
        dataSource.setUsername(env.getProperty("username"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hbm2ddl.auto"));
        properties.setProperty("hibernate.dialect", env.getProperty("dialect"));
        properties.setProperty("hibernate.ejb.naming_strategy", env.getProperty("ejb.naming_strategy"));
        properties.setProperty("hibernate.connection.charSet", env.getProperty("connection.charSet"));
        properties.setProperty("hibernate.connection.characterEncoding", env.getProperty("connection.characterEncoding"));
        properties.setProperty("hibernate.connection.useUnicode", env.getProperty("connection.useUnicode"));
        properties.setProperty("hibernate.show_sql", env.getProperty("show_sql"));
        properties.setProperty("hibernate.format_sql", env.getProperty("format_sql"));
        properties.setProperty("hibernate.use_sql_comments", env.getProperty("use_sql_comments"));
        properties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("cache.use_second_level_cache"));
        properties.setProperty("hibernate.javax.cache.provider", env.getProperty("javax.cache.provider"));
        properties.setProperty("hibernate.cache.use_query_cache", env.getProperty("cache.use_query_cache"));
        return properties;
    }

}
