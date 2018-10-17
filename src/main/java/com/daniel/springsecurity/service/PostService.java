package com.daniel.springsecurity.service;

import java.util.List;

import com.daniel.springsecurity.model.extra.Post;
import com.daniel.springsecurity.model.extra.User;

public interface PostService {

	public void addPost(Post p, User user);
	public List<Post> listPosts();
	public List<Post> getPostsById(int id);
	public void removePost(int id);
	public List<Post> findAllByUserId(int userId);
}
