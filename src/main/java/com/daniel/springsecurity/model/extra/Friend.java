package com.daniel.springsecurity.model.extra;

import javax.persistence.*;


@Entity
@Table(name="friends")
public class Friend {

	@Id
	@Column(name="friend_id")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int friendId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
