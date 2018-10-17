package com.daniel.springsecurity.dao;

import java.util.List;

import com.daniel.springsecurity.model.extra.Post;

public interface PostDAO {

	void removePost(int id);

	List<Post> listPosts();

	Post getPostById(int id);
	
	void addPost(Post p);

	List<Post> getPostsById(int id);

	List<Post> findAllByUserId(int userId);

}
