package org.impelsys.SpringBootDemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.impelsys.SpringBootDemo.data.UserRepository;
import org.impelsys.SpringBootDemo.exception.UserNotFoundException;
import org.impelsys.SpringBootDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		List<User> userList=new ArrayList();
		userRepository.findAll().forEach(userList::add);
		return userList;
	}
	
	public User getUser(int id) throws UserNotFoundException{
		// TODO Auto-generated method stub
		User user = userRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException(id));
				return user;
	}

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("User: "+user);
		return userRepository.save(user);
	}

	/*
	 * public User addUser(User user1) { // TODO Auto-generated method stub return
	 * user1; }
	 */
}
