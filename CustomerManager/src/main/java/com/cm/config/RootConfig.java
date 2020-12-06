package com.cm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cm.services.CustomerService;

@Configuration
@ComponentScan(basePackages = {"com.cm.services"})
@EnableTransactionManagement
@Import(JPAConfig.class)
public class RootConfig {

	
}
	