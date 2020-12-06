package com.bookapi.config;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.bookapi.model.Book;

@Configuration
@ComponentScan(basePackages = { "com.bookapi.dao" })
@PropertySource("classpath:db.properties")
public class PersistanceConfig {

	@Autowired
	private Environment env;

	/*
	 * @Bean public DriverManagerDataSource getDriverManagerDataSource() {
	 * 
	 * DriverManagerDataSource DriverManagerDataSource=null;
	 * DriverManagerDataSource=new DriverManagerDataSource();
	 * DriverManagerDataSource.setDriverClassName(env.getProperty(
	 * "db.driverclassname"));
	 * DriverManagerDataSource.setUrl(env.getProperty("db.url"));
	 * DriverManagerDataSource.setUsername(env.getProperty("db.username"));
	 * DriverManagerDataSource.setPassword(env.getProperty("db.password")); return
	 * DriverManagerDataSource; }
	 */

	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean LocalSessionFactoryBean = null;
		LocalSessionFactoryBean = new LocalSessionFactoryBean();
		Properties Hibernateproperties = null;
		Hibernateproperties = new Properties();

		// myql properties
		Hibernateproperties.put(DRIVER, env.getProperty("db.driverclassname"));
		Hibernateproperties.put(URL, env.getProperty("db.url"));
		Hibernateproperties.put(USER, env.getProperty("db.username"));
		Hibernateproperties.put(PASS, env.getProperty("db.password"));

		// setting hibernate properties
		Hibernateproperties.put(DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		Hibernateproperties.put(SHOW_SQL, "true");
		Hibernateproperties.put(HBM2DDL_AUTO, "update");

		Hibernateproperties.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		Hibernateproperties.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		Hibernateproperties.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		Hibernateproperties.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		Hibernateproperties.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

		LocalSessionFactoryBean.setHibernateProperties(Hibernateproperties);
		LocalSessionFactoryBean.setAnnotatedClasses(Book.class);
		return LocalSessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager() {
		HibernateTransactionManager HibernateTransactionManager = new HibernateTransactionManager();
		HibernateTransactionManager.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return HibernateTransactionManager;
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate();
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();

		// Set the maximum allowed size (in bytes) for each individual file.
		// resolver.setMaxUploadSize(5242880);//5MB

		resolver.setMaxUploadSize(524288);// 0.5MB

		// You may also set other available properties.
		return resolver;
	}

}
