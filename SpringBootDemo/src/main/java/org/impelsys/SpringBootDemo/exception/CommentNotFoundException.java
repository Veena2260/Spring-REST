package org.impelsys.SpringBootDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="This Comment is not found in system")

public class CommentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CommentNotFoundException(int id) {
		super(String.format("Comment not found!1", id));
	}
}
