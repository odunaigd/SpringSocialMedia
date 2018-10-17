package com.daniel.springsecurity.dao;

import java.util.List;

import com.daniel.springsecurity.model.extra.Friend;

public interface FriendDAO {

	void addFriend(Friend f);

	List<Friend> listFriends();

	Friend getFriendById(int id);

	void removeFriend(int id);
	
	List<Friend> getFriendsById(int id);

}
