package com.bookapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.bookapi.service"})
@EnableTransactionManagement
@Import(PersistanceConfig.class)
public class RootConfig {

}
