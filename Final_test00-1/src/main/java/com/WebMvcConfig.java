package com;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS
	= {
			"classpath:/static/", 
			"classpath:/resources/", 
			"classpath:/META-INF/resources"
	};

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//url mapping "/"로 접속하면 main/list로 이동한다.
		registry.addViewController("/").setViewName("forward:/main/list");
	}
	//test
  	@Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("/resources/**")
	  .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS); 
	  }
}
