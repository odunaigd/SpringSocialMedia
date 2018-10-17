package com.daniel.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.springsecurity.dao.FriendRequestDAO;
import com.daniel.springsecurity.model.extra.FriendRequest;
import com.daniel.springsecurity.model.extra.User;

@Service
public class FriendRequestSvcImpl implements FriendRequestSvc {
	
	@Autowired
	private FriendRequestDAO friendRequestDAO;

	
	@Override
	@Transactional
	public void addFriendRequest(FriendRequest f, User u) {
		f.setUser(u);
		friendRequestDAO.addFriendRequest(f);
	}
	
	@Override
	@Transactional
	public List<FriendRequest> listFriendRequests() {
		
		return friendRequestDAO.listFriendRequests();
		
	}
	
	@Override
	@Transactional
	public List<FriendRequest> getFriendRequestsById(int id) {
		
		return friendRequestDAO.getFriendRequestsById(id);
		
	}
	
	@Override
	@Transactional
	public void removeFriendRequest(int id) {
		
		friendRequestDAO.removeFriendRequest(id);
	}
	
	public List<FriendRequest> findAllByUserId(int userId) {
		
		return friendRequestDAO.findAllByUserId(userId);
	}

}
