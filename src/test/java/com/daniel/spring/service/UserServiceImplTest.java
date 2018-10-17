package com.daniel.spring.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.daniel.springsecurity.dao.*;
import com.daniel.springsecurity.model.*;
import com.daniel.springsecurity.model.extra.User;
import com.daniel.springsecurity.service.UserServiceImpl;

public class UserServiceImplTest {
	
	@Mock
    UserDao dao;
     
    @InjectMocks
    UserServiceImpl userService;
     
    @Spy
    List<User> users = new ArrayList<User>();
     
    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        users = getUserList();
    }
 
    @Test
    public void findById(){
        User emp = users.get(0);
        when(dao.findById(anyInt())).thenReturn(emp);
        Assert.assertEquals(userService.findById(emp.getId()),emp);
    }
 
    @Test
    public void saveUser(){
        doNothing().when(dao).saveUser(any(User.class));
        userService.saveUser(any(User.class));
        verify(dao, atLeastOnce()).saveUser(any(User.class));
    }
 
    @Test
    public void deleteUserByUsername(){
        doNothing().when(dao).deleteUserByUsername(anyString());
        userService.deleteUserByUsername(anyString());
        verify(dao, atLeastOnce()).deleteUserByUsername(anyString());
    }
     
    @Test
    public void findAllUsers(){
        when(dao.findAllUsers()).thenReturn(users);
        Assert.assertEquals(userService.findAllUsers(), users);
    }
     
    @Test
    public void findUserByUsername(){
        User emp = users.get(0);
        when(dao.findByUsername(anyString())).thenReturn(emp);
        Assert.assertEquals(userService.findByUsername(anyString()), emp);
    }
 
    @Test
    public void isUsernameUnique(){
        User emp = users.get(0);
        when(dao.findByUsername(anyString())).thenReturn(emp);
        Assert.assertEquals(userService.isUsernameUnique(emp.getId(), emp.getUsername()), true);
    }
     
     
    public List<User> getUserList(){
        User e1 = new User();
        e1.setId(1);
        e1.setName("Axel");
        e1.setPassword("axel");
        e1.setUsername("XXX111");
         
        User e2 = new User();
        e2.setId(2);
        e2.setName("Jeremy");
        e2.setPassword("kyle");
        e2.setUsername("XXX222");
         
        users.add(e1);
        users.add(e2);
        return users;
    }

}
