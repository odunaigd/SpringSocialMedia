package com.daniel.springsecurity.dao;

import java.util.List;

import com.daniel.springsecurity.model.extra.FriendRequest;

public interface FriendRequestDAO {
	
	public void addFriendRequest(FriendRequest f);
	public List<FriendRequest> listFriendRequests();
	public List<FriendRequest> getFriendRequestsById(int id);
	public void removeFriendRequest(int id);
	public List<FriendRequest> findAllByUserId(int userId);

}
