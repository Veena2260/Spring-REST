package org.impelsys.SpringBootDemo;

import org.impelsys.SpringBootDemo.controller.CommentController;
import org.impelsys.SpringBootDemo.dao.impl.CommentDaoImpl;
import org.impelsys.SpringBootDemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc
@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration(exclude= { SecurityAutoConfiguration.class,
		ManagementWebSecurityAutoConfiguration.class
		//SecurityFilterAutoConfiguration.class,
		//ManagementWebSecurityAutoConfiguration.class
	
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@ComponentScan(basePackages={"org.impelsys.controller" , "org.impelsys.resources","org.impelsys.config"})
@ComponentScan(basePackageClasses= {CommentController.class,CommentService.class,CommentDaoImpl.class})
public class SpringBootDemoApplication {
	
	
	public static void main(String[] args) {
		//System.setProperty("server.servlet.context-path", "/SpringBootDemo");
		
		ApplicationContext context =  SpringApplication.run(SpringBootDemoApplication.class,args);
		System.out.println("Hello welcome to the world of springBoot");
}
}