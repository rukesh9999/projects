package com.crm.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.crm.rest.aspect","com.crm.rest.services"})
@EnableTransactionManagement
@Import(PersistanceConfig.class)
@EnableAspectJAutoProxy
public class RootConfig {

}
