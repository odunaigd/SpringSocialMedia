package com.daniel.springsecurity.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.springsecurity.dao.UserDao;
import com.daniel.springsecurity.model.extra.Post;
import com.daniel.springsecurity.model.extra.User;
import com.daniel.springsecurity.model.extra.UserProfile;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		
		//user.setState("Active");
		dao.saveUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		 User entity = dao.findById(user.getId());
	        if(entity!=null){
	            entity.setName(user.getName());
	            entity.setUsername(user.getUsername());
	            entity.setPassword(user.getPassword());
	        }
		
	}

	@Override
	public void deleteUserByUsername(String username) {
		dao.deleteUserByUsername(username);
		
	}

	@Override
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public boolean isUsernameUnique(Integer id, String username) {
		User user = findByUsername(username);
        return ( user == null || ((id != null) && (user.getId() == id)));
    
	}

	@Override
	public void addPost(Post post) {
		dao.addPost(post);
		
	}

	@Override
	public int findIdByUsername(String username) {
		return dao.findIdByUsername(username);
	}

	
}
