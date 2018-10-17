package com.daniel.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.springsecurity.dao.FriendDAO;
import com.daniel.springsecurity.model.extra.Friend;
import com.daniel.springsecurity.model.extra.User;

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendDAO friendDAO;


	@Override
	@Transactional
	public void addFriend(Friend p,int i, User u) {
		p.setUser(u);
		p.setFriendId(i);
		friendDAO.addFriend(p);
	}


	@Override
	@Transactional
	public List<Friend> listFriends() {
		return friendDAO.listFriends();
	}

	@Override
	@Transactional
	public Friend getFriendById(int id) {
		return friendDAO.getFriendById(id);
	}

	@Override
	@Transactional
	public void removeFriend(int id) {
		friendDAO.removeFriend(id);
	}


	@Override
	@Transactional
	public List<Friend> getFriendsById(int currentUserId) {
		return friendDAO.getFriendsById(currentUserId);
	}

}
