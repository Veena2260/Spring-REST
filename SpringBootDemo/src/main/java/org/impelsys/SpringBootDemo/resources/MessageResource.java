package org.impelsys.SpringBootDemo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//Resource URI
@Service
@Path("/messages")

public class MessageResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessages() {
		System.out.println("Inside getMessages()");
		return "Hello User";
	}

}
