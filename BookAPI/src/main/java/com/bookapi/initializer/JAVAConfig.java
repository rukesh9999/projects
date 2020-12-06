package com.bookapi.initializer;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bookapi.config.RootConfig;
import com.bookapi.config.webMVCConfig;

public class JAVAConfig  extends  AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {webMVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
