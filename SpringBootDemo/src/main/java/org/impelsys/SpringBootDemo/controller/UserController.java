package org.impelsys.SpringBootDemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.impelsys.SpringBootDemo.dao.impl.CommentDaoImpl;
import org.impelsys.SpringBootDemo.exception.CommentNotFoundException;
import org.impelsys.SpringBootDemo.exception.UserNotFoundException;
import org.impelsys.SpringBootDemo.model.Comment;
import org.impelsys.SpringBootDemo.model.User;
import org.impelsys.SpringBootDemo.service.CommentService;
import org.impelsys.SpringBootDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/*@Controller
@ResponseBody*/
@RequestMapping("/users")
@RestController("userController")
public class UserController {
	
		@Autowired
		UserService userService;
		
		
		/*
		 * @GetMapping(value="/list",produces="application/json") public List<Comment>
		 * getComments(){ List<Comment> commentsList=commentService.getAllComments();
		 * return commentsList; }
		 */
		 
		@GetMapping(value="/userlist",produces="application/json")
		public ResponseEntity<List<User>> getUsers(){
			List<User> UsersList=userService.getAllUsers();
			ResponseEntity<List<User>> responseEntity=new ResponseEntity<List<User>>(UsersList,HttpStatus.OK);
			return responseEntity;
		}
		@GetMapping(value="/user/{id}",produces="application/json")
		public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException{
			User user=userService.getUser(id);
			//System.out.println("u got the output");
			
			ResponseEntity<User> responseEntity=new ResponseEntity<User>(user,HttpStatus.OK);
			return responseEntity;
		}
		/*
		 * @PostMapping(value="/add",consumes="application/json",produces=
		 * "application/json") public ResponseEntity<User> addUser(User user1){ User
		 * user2=userService.addUser(user1); ResponseEntity<User> responseEntity;
		 * responseEntity=new ResponseEntity<User>(user2,HttpStatus.OK); return
		 * responseEntity;
		 * 
		 * 
		 * }
		 */

		/*
		 * @ExceptionHandler(CommentNotFoundException.class) public void
		 * handlerForCommentsNotFound(HttpServletRequest req,HttpServletResponse rs) {
		 * System.out.println("Will look into this issue"); }
		 */
		@PostMapping(value="/user",consumes=MediaType.APPLICATION_JSON,produces=MediaType.APPLICATION_JSON)
		public User saveUser(User user) {
			System.out.println("User" +user);

			return userService.saveUser(user);
		}

}
