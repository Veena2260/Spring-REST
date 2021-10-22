package org.impelsys.SpringBootDemo.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.websocket.server.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.impelsys.SpringBootDemo.dao.UserDao;
import org.impelsys.SpringBootDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import javax.ws.rs.core.MediaType;

@Service
@Path("/users")
public class UserResources {
	/*
	 * @Autowired SessionFactory sessionFactory;
	 */
	
	
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {
		List<User> userlist=userDao.listUsers();
		Response.ResponseBuilder builder=Response.status(Status.OK);
		Response response=builder.entity(userlist).build();
		return response;

	}
	
	@DELETE
	@Path("/remove/{id}")
	public Response delete(@PathParam("id") int id) {
		userDao.deleteUser(id);
		Response.ResponseBuilder builder=Response.status(Status.OK);
		Response response=builder.entity(id).build();
		return response;
		
	}
	
	

	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int id) {
		//db call
		
		/*
		 * System.out.println("In getUserId()"); User user=new User();
		 * user.setUserMail("abc@gamil.com"); user.setUserName("XYZ"); user.setId(id);
		 */
		  
		 
		//Session session=sessionFactory.openSession();
		User user=userDao.viewUser(id);
		
		System.out.println("In getUserId()");
		Response.ResponseBuilder builder=Response.status(Status.OK);
		Response response=builder.entity(user).build();
		//session.close();
		return response;
		
		//return Response.status(200).entity(user).build();
		
	}
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		
		int id=userDao.addUser(user);
		System.out.println("In AddUser()");
		Response.ResponseBuilder builder=Response.status(Status.OK);
		Response response=builder.entity("created user : "+id).build();
		return response;
		
		
	}

}
