package com.daniel.springsecurity.model.extra;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="friendrequests")
public class FriendRequest {
	
	@Id
	@Column(name="request_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int requestId;
	
	@Column(name="friends_id")
	private int friendId;
	
	@Column(name="status")
	private int status;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendUserId) {
		this.friendId = friendUserId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
