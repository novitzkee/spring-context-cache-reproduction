package org.novitzkee;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.tool.schema.Action;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class PersistenceTestConfiguration {

    static {
        System.setProperty("org.jboss.logging.provider", "slf4j");
    }

    private static final String PACKAGE_TO_SCAN = "org.novitzkee";

    private static final String H2_JDBC_USER = "sa";

    private static final String H2_JDBC_URL = "jdbc:h2:mem:test_db;INIT=CREATE SCHEMA IF NOT EXISTS MODULE;DB_CLOSE_DELAY=-1";

    @Bean
    PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        final HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(AvailableSettings.DRIVER, org.h2.Driver.class.getName());
        hibernateProperties.setProperty(AvailableSettings.URL, H2_JDBC_URL);
        hibernateProperties.setProperty(AvailableSettings.USER, H2_JDBC_USER);
        hibernateProperties.setProperty(AvailableSettings.PASS, "");
        hibernateProperties.setProperty(AvailableSettings.HBM2DDL_AUTO, Action.CREATE_DROP.getExternalHbm2ddlName());

        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(new BasicDataSource());
        sessionFactory.setPackagesToScan(PACKAGE_TO_SCAN);
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
}
