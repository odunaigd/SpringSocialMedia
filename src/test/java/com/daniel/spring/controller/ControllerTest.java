package com.daniel.spring.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.atLeastOnce;

import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.daniel.springsecurity.controller.HelloWorldController;
import com.daniel.springsecurity.model.extra.User;
import com.daniel.springsecurity.service.UserService;
 

public class ControllerTest {
	
	@Mock
    UserService service;
     
    @Mock
    MessageSource message;
     
    @InjectMocks
    HelloWorldController appController;
     
    @Spy
    List<User> users = new ArrayList<User>();
 
    @Spy
    ModelMap model;
     
    @Mock
    BindingResult result;
	
    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        users = getUserList();
    }
     
     
    @Test
    public void newUser(){
        Assert.assertEquals(appController.homePage(model), "welcome");
        Assert.assertNotNull(model.get("user"));
        Assert.assertFalse((Boolean)model.get("edit"));
        Assert.assertEquals(((User)model.get("user")).getId(), 0);
    }
 
 
    @Test
    public void saveUserWithValidationError(){
        when(result.hasErrors()).thenReturn(true);
        doNothing().when(service).saveUser(any(User.class));
        Assert.assertEquals(appController.saveUser(users.get(0), result, model), "welcome");
    }
 
    @Test
    public void saveUserWithValidationErrorNonUniqueSSN(){
        when(result.hasErrors()).thenReturn(false);
        when(service.isUsernameUnique(anyInt(), anyString())).thenReturn(false);
        Assert.assertEquals(appController.saveUser(users.get(0), result, model), "welcome");
    }
 
     
    @Test
    public void saveUserWithSuccess(){
        when(result.hasErrors()).thenReturn(false);
        when(service.isUsernameUnique(anyInt(), anyString())).thenReturn(true);
        doNothing().when(service).saveUser(any(User.class));
        Assert.assertEquals(appController.saveUser(users.get(0), result, model), "profile");
        Assert.assertEquals(model.get("profile"), "User Axel registered successfully");
    }
 
 
    public List<User> getUserList(){
        User e1 = new User();
        e1.setId(1);
        e1.setName("Axel");
        e1.setPassword("axel");
        e1.setUsername("XXX111");
         
        User e2 = new User();
        e2.setId(2);
        e2.setName("Rose");
        e2.setPassword("rose");
        e2.setUsername("XXX111");
         
         
        users.add(e1);
        users.add(e2);
        return users;
    }
}


