package com.daniel.springsecurity.model.extra;


import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postId;
	
	@Column(name="post_name")
	private String postName;
	
	@Column(name="post_content")
	private String postContent;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
