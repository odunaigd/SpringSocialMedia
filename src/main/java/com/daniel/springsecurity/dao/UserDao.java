package com.daniel.springsecurity.dao;

import java.util.List;

import com.daniel.springsecurity.model.extra.Post;
import com.daniel.springsecurity.model.extra.User;

public interface UserDao {

	User findById(int id);
	
	User findByUsername(String username);
	
    void saveUser(User user);
    
    void deleteUserByUsername(String username);
     
    List<User> findAllUsers();

	void addPost(Post post);

	int findIdByUsername(String username);
	
	//void addFriend(Friend friend);
	
}

