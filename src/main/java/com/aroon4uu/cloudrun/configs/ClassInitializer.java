package com.aroon4uu.cloudrun.configs;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aroon4uu.cloudrun.servlets.HelloServlet1;
import com.aroon4uu.cloudrun.servlets.HelloServlet2;

import jakarta.servlet.http.HttpServlet;

@Configuration
public class ClassInitializer {
	@Bean
	public ServletRegistrationBean<HttpServlet> processorInitiatorCron() {
		ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
		servRegBean.setServlet(new HelloServlet1());
		servRegBean.addUrlMappings("/hello-servlet-1");
		servRegBean.setLoadOnStartup(1);
		return servRegBean;
	}
	@Bean
	public ServletRegistrationBean<HttpServlet> processorClientModuleTask() {
		ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
		servRegBean.setServlet(new HelloServlet2());
		servRegBean.addUrlMappings("/hello-servlet-2");
		servRegBean.setLoadOnStartup(1);
		return servRegBean;
	}
}
