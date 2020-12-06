package com.cm.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = {"com.cm.repository"})
public class JPAConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean getentityLocalEntityManagerFactoryBean()
	{
		LocalEntityManagerFactoryBean localEntityManagerFactoryBean=null;
		localEntityManagerFactoryBean=new  LocalEntityManagerFactoryBean();
		localEntityManagerFactoryBean.setPersistenceUnitName("customerManager");
		return localEntityManagerFactoryBean;
	}
	
	@Bean(autowire = Autowire.BY_TYPE)
	public  JpaTransactionManager getJpaTransactionManagerJpa(EntityManagerFactory  entityManagerFactory)
	{
		JpaTransactionManager  jpaTransactionManager=null;
		jpaTransactionManager=new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		
		return jpaTransactionManager;
	}

}
