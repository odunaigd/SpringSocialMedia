package com.daniel.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.springsecurity.dao.PostDAO;
import com.daniel.springsecurity.model.extra.Post;
import com.daniel.springsecurity.model.extra.User;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO postDAO;

	
	@Override
	@Transactional
	public void addPost(Post p, User u) {
		p.setUser(u);
			postDAO.addPost(p);
	}


	@Override
	@Transactional
	public List<Post> listPosts() {
		return postDAO.listPosts();
	}

	@Override
	@Transactional
	public List<Post> getPostsById(int id) {
		return postDAO.getPostsById(id);
	}

	@Override
	@Transactional
	public void removePost(int id) {
				postDAO.removePost(id);
	}


	@Override
	public List<Post> findAllByUserId(int userId) {
		
		return postDAO.findAllByUserId(userId);
	}

}
