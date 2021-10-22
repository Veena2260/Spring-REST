package org.impelsys.SpringBootDemo.exception;

public class UserNotFoundException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(int id) {
		super(String.format("User not found!1", id));
	}
}



