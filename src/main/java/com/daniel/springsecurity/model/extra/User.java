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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*import com.daniel.springsecurity.extra.Friend;
import com.daniel.springsecurity.extra.Photo;*/



@Entity
@Table(name="users")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;

	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
		
	@Column(name="name", nullable=false)
	private String name;

	@Column(name="state", nullable=false)
	private String state=State.ACTIVE.getState();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "APP_USER_USER_PROFILE", 
             joinColumns = { @JoinColumn(name = "user_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "user_profile_id") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

	@OneToMany(mappedBy = "user"/*,fetch = FetchType.EAGER*/)
	private Set<Friend> friends  = new HashSet<Friend>();
	
	/*@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_posts", 
    joinColumns = { @JoinColumn(name = "user_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "user_post_id") })*/
	
	@OneToMany(mappedBy = "user")
	private Set<Post> posts = new HashSet<Post>();
	
	@OneToMany(mappedBy = "user")
	private Set<FriendRequest> frqs = new HashSet<FriendRequest>();
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
	private Set<Photo> photos = new HashSet<Photo>();*/
	
	public int getId() {
		return userId;
	}

	public void setId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}	

	public Set<Friend> getFriends() {
		return friends;
	}

	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	/*public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", ssoId=" + username + ", password=" + password
				+ ", firstName=" + name + ", state=" + state + ", userProfiles=" + userProfiles +"]";
	}

	
}
