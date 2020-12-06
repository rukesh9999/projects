package com.spf.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.spf.bo.saveRechargePlanBo;

@Configuration
@ComponentScan(basePackages = {"com.spf.dao"})
@PropertySource("classpath:db.properties")
public class persistanceConfig {
    
	@Autowired
	private Environment env;
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource()
	{ 
		DriverManagerDataSource  DriverManagerDataSource=null;
		DriverManagerDataSource=new DriverManagerDataSource();
		DriverManagerDataSource.setDriverClassName(env.getProperty("driverclassname"));
		DriverManagerDataSource.setUrl(env.getProperty("url"));
		DriverManagerDataSource.setUsername(env.getProperty("username"));
		DriverManagerDataSource.setPassword(env.getProperty("password"));
		
		return  DriverManagerDataSource;
	}
	
	
	
	@Bean(autowire = Autowire.BY_TYPE)
	public LocalSessionFactoryBean getLocalSessionFactoryBean()
	{
		Properties Hibernateproperties=null;
		LocalSessionFactoryBean localSessionFactoryBean=null;
		localSessionFactoryBean=new LocalSessionFactoryBean();
		Hibernateproperties=new Properties();
		Hibernateproperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle9Dialect");
		Hibernateproperties.put("show_sql", "true");
		Hibernateproperties.put("hibernate.hbm2ddl.auto", "update");
		localSessionFactoryBean.setHibernateProperties(Hibernateproperties);
		localSessionFactoryBean.setAnnotatedClasses(saveRechargePlanBo.class);
		
		return localSessionFactoryBean;
		
	}
	
	
	@Bean(autowire = Autowire.BY_TYPE)
	public PlatformTransactionManager getTransactionManager()
	{
		  return new HibernateTransactionManager();
	}
	
	
	
	@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTemplate getHibernateTemplate()
	{
		return new HibernateTemplate();
	}
}
