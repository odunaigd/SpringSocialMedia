package com.daniel.springsecurity.service;

import java.util.List;

import com.daniel.springsecurity.model.extra.Friend;
import com.daniel.springsecurity.model.extra.FriendRequest;
import com.daniel.springsecurity.model.extra.User;

public interface FriendService {

	public void addFriend(Friend f, int i, User u);
	public List<Friend> listFriends();
	public Friend getFriendById(int id);
	public void removeFriend(int id);
	public List<Friend> getFriendsById(int currentUserId);
	
}