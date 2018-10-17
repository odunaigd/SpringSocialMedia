package com.daniel.springsecurity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.daniel.springsecurity.model.*;
import com.daniel.springsecurity.model.extra.Friend;
import com.daniel.springsecurity.model.extra.FriendRequest;
import com.daniel.springsecurity.model.extra.Post;
//import com.daniel.springsecurity.model.extra.Post;
import com.daniel.springsecurity.model.extra.User;
import com.daniel.springsecurity.extra.*;
import com.daniel.springsecurity.service.*;

@Controller
public class HelloWorldController {
	
	String currentUsername;
	String friendUsername;
	int friendPostId;
	int currentUserId;
	int friendUserId;

	@Autowired
	FriendService friendService;
	
	@Autowired
	FriendRequestSvc friendRequestService;
	/*
	@Autowired
	PhotoService photoService;*/
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hi, Welcome to Daniel's Social Media Site");
		model.addAttribute("userForm", new User());
		return "welcome";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.POST)
	public String saveUser(User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "redirect:/home";
		}

		if (userService.isUsernameUnique(user.getId(), user.getUsername())) {

			userService.saveUser(user);

			model.addAttribute("success", "User " + user.getName() + " registered successfully");
			return "redirect:/login";
		} else
			return "redirect:/home";

	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(Model model) {
		List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "list";
	}
	@RequestMapping(value = "/photo", method = RequestMethod.GET)
	public String photoPage(Model model) {
		
		return "photo";
	}
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String postPage(ModelMap model) {
		currentUsername = getPrincipal();
		currentUserId = userService.findIdByUsername(currentUsername);
		List<Post> posts = postService.getPostsById(currentUserId);
		model.addAttribute("posts", posts);
		model.addAttribute("postForm", new Post());
		return "post";
	}
	
	@RequestMapping(value="/myRequests", method = RequestMethod.GET)
	public String myRequests(Model model) {
		List<FriendRequest> frqs = friendRequestService.getFriendRequestsById(currentUserId);
		model.addAttribute("requests", frqs);
		return "requests";
	}
	
	@RequestMapping(value="/myFriends", method = RequestMethod.GET)
	public String myFriends(Model model) {
		List<Friend> frqs = friendService.getFriendsById(currentUserId);
		model.addAttribute("friends", frqs);
		return "listFriends";
	}
	
	@RequestMapping(value="/addFriend/{username}", method = RequestMethod.GET)
	public String addFriend(@PathVariable("username")String username){
		User user = userService.findById(currentUserId);
		friendUserId = userService.findIdByUsername(username);
		System.out.println("TESTING:" + friendUserId);
		FriendRequest frq = new FriendRequest();
		//frq.setRequestId(1);
		frq.setFriendId(friendUserId);
		frq.setStatus(1);
		friendRequestService.addFriendRequest(frq, user);
		return "redirect:/list";
		
	}
	
	@RequestMapping(value="/acceptRequest/{username}", method = RequestMethod.GET)
	public String acceptRequest(@PathVariable("username")String username){
		User user = userService.findById(currentUserId);
		friendUserId = userService.findIdByUsername(username);
		User friend = userService.findById(friendUserId);
		Friend f1 = new Friend();
		Friend f2 = new Friend();
		friendService.addFriend(f1, friendUserId, user);
		
		friendService.addFriend(f2, currentUserId, friend);
		return "redirect:/profile";
		
	}
	
	@RequestMapping(value = "/listFriends", method = RequestMethod.GET)
	public String listFriends(Model model) {
		List<Friend> friends = friendService.listFriends();
        model.addAttribute("friends", friends);
        model.addAttribute("loggedinuser", getPrincipal());
        return "listFriends";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String postPage(Post post, BindingResult result, ModelMap model) {
		//String uname = getPrincipal();
		if (result.hasErrors()) {
			return "redirect:/post";
		}

		else {
			User user = userService.findById(currentUserId);
			postService.addPost(post, user);
			model.addAttribute("postForm", new Post());
			return "redirect:/post";
		}
			
	}
	
	@RequestMapping(value = "/friendsPost/{username}", method = RequestMethod.GET)
	public String friendsPost(@PathVariable("username") String username, ModelMap model) {
		currentUsername = getPrincipal();
		System.out.println(username);
		friendPostId = userService.findIdByUsername(username);
		List<Post> posts = postService.getPostsById(friendPostId);
		model.addAttribute("posts", posts);
		model.addAttribute("postForm", new Post());
		return "friendsPost";
	}
	
	@RequestMapping(value = "/friendsPost/{username}", method = RequestMethod.POST)
	public String friendsPost(@PathVariable("username")String username, Post post, BindingResult result, ModelMap model) {
	if (result.hasErrors()) {
		return "redirect:/myFriends";
	}

	else {
		User user = userService.findById(friendPostId);
		postService.addPost(post, user);
		model.addAttribute("postForm", new Post());
		return "redirect:/friendsPost/{username}";
	}
	}
	
	@RequestMapping(value = { "/add-post/{userId}" }, method = RequestMethod.GET)
    public String addDocuments(@PathVariable int userId, ModelMap model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);

 
        List<Post> posts = postService.findAllByUserId(userId);
        model.addAttribute("posts", posts);
         
        return "post";
    }
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
		} else {
			
			return "redirect:/profile";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profilePage(ModelMap model) {
		//int id = getCurrentlyAuthenticatedUser();
		currentUsername = getPrincipal();
		currentUserId = userService.findIdByUsername(currentUsername);
		System.out.println("uid = " + currentUserId);
		List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        //model.addAttribute("uid", id);
        return "profile";
		
	}
	
	@RequestMapping(value = "/profile/{id}/post/{id}", method = RequestMethod.GET)
	public String friendProfilePage(@PathVariable("id") String id, ModelMap model) {
		List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "post";
		
	}
	

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	public int getCurrentlyAuthenticatedUser() {
	   // User currentUser=new User();

	    Authentication a = SecurityContextHolder.getContext().getAuthentication();
	    User currentUser = (User)a.getPrincipal();
	    return currentUser.getId();
	}

	/**
	 * This method returns true if users is already authenticated [logged-in],
	 * else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}
	
	/*private void savePost(User user) {
        
        Post post = new Post();
         
        //MultipartFile multipartFile = fileBucket.getFile();
         
        post.setPostName(postName);
        post.setPostContent(postContent);
        post.setUser(user);
        postService.addPost(post);
    }*/

}