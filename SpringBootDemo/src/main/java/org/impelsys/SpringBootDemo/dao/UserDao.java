package org.impelsys.SpringBootDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.impelsys.SpringBootDemo.model.User;

public interface UserDao {
	int addUser(User user);
	User viewUser(int id);
	void deleteUser(int id);
	
	//User viewUser(int id,Session session);
	List<User> listUsers();
	

}
