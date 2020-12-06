package com.crm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.crm.aspect","com.crm.services"})
@EnableTransactionManagement
@Import(PersistanceConfig.class)
@EnableAspectJAutoProxy
public class RootConfig {

}
