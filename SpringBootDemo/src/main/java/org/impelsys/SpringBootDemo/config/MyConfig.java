package org.impelsys.SpringBootDemo.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.impelsys.SpringBootDemo.resources.MessageResource;
import org.impelsys.SpringBootDemo.resources.UserResources;
import org.springframework.context.annotation.Configuration;


@Configuration
@ApplicationPath("/rest")
public class MyConfig extends ResourceConfig{
	
	@PostConstruct
	public void init() {
	register(MessageResource.class);
	//register(UserResources.class);
	}

}
