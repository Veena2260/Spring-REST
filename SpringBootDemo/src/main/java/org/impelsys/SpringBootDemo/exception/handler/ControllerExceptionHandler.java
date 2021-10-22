package org.impelsys.SpringBootDemo.exception.handler;

import org.impelsys.SpringBootDemo.exception.CommentNotFoundException;
import org.impelsys.SpringBootDemo.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice  //Intercepter for exceptions occurring in all controllers
@ResponseBody
public class ControllerExceptionHandler {
	
	
	@ExceptionHandler(CommentNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public String handlerForCommentsNotFound(CommentNotFoundException ce) {
		return "will Look into this issues: " +ce.getMessage();
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)

	public String handlerForUserNotFound(UserNotFoundException ue) {
		System.out.println("in Exception Handler");
		//String msg="will Look into this issues: "+ue.getMessage();
		return "will Look into this issues: " +ue.getMessage();
	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="User Not Found")

	public String handleAllExceptions(Exception e) {
		return e.getMessage();
	}

}
