package com.daniel.springsecurity.service;

import java.util.List;

import com.daniel.springsecurity.model.extra.FriendRequest;
import com.daniel.springsecurity.model.extra.User;

public interface FriendRequestSvc {
	
	public void addFriendRequest(FriendRequest f, User u);
	public List<FriendRequest> listFriendRequests();
	public List<FriendRequest> getFriendRequestsById(int currentUserId);
	public void removeFriendRequest(int id);
	public List<FriendRequest> findAllByUserId(int userId);

}
