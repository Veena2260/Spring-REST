package org.impelsys.SpringBootDemo.service;

import java.util.List;

import org.impelsys.SpringBootDemo.dao.impl.CommentDaoImpl;
import org.impelsys.SpringBootDemo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service

public class CommentService {
	@Autowired
	CommentDaoImpl commentDao;
	
	
	public List<Comment> getAllComments(){
		
		return commentDao.listComments();
	}
	
public Comment getComment(int id) {
	//Comment c=new Comment();
	//c.setCommentContent("Comment abcdef");
		return commentDao.getComment(id);
	//return c;
	}


}
