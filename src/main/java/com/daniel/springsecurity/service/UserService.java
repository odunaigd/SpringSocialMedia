package com.daniel.springsecurity.service;

import java.util.List;

import com.daniel.springsecurity.model.extra.Post;
import com.daniel.springsecurity.model.extra.User;

public interface UserService {

	User findById(int id);
	
	User findByUsername(String username);
	
    void saveUser(User user);
    
    void updateUser(User user);
     
    void deleteUserByUsername(String username);
 
    List<User> findAllUsers();
    
    boolean isUsernameUnique(Integer id, String username);

	void addPost(Post post);
	
	int findIdByUsername(String username);
	
	//void addFriend(Friend friend);
}