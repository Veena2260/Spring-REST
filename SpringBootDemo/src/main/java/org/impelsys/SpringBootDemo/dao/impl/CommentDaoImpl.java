package org.impelsys.SpringBootDemo.dao.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.impelsys.SpringBootDemo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Repository
public class CommentDaoImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Comment> listComments(){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Comment",Comment.class);
		List<Comment>  commentsList=query.list();
		session.close();
		return commentsList;
		
	}

	public Comment getComment(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Comment comment=session.get(Comment.class,new Integer(id));
		if(comment!=null)
		System.out.println("Comment:"+comment);
		session.close();
		return comment;
	}
	
	
	
}
