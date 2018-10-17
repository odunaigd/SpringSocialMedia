package com.daniel.spring.dao;

import java.math.BigDecimal;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.daniel.springsecurity.dao.UserDao;
import com.daniel.springsecurity.model.extra.User;

public class UserDaoImplTest extends EntityDaoImplTest {
	
	@Autowired
    UserDao userDao;
 
	@Override
    protected IDataSet getDataSet() throws Exception{
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("User.xml"));
        return dataSet;
    }
     
 
    @Test
    public void findById(){
        Assert.assertNotNull(userDao.findById(1));
        Assert.assertNull(userDao.findById(3));
    }
 
     
    @Test
    public void saveUser(){
        userDao.saveUser(getSampleUser());
        Assert.assertEquals(userDao.findAllUsers().size(), 3);
    }
     
    @Test
    public void deleteUserByUsername(){
        userDao.deleteUserByUsername("11111");
        Assert.assertEquals(userDao.findAllUsers().size(), 1);
    }
     
    @Test
    public void deleteUserByInvalidUsername(){
        userDao.deleteUserByUsername("23423");
        Assert.assertEquals(userDao.findAllUsers().size(), 2);
    }
 
    @Test
    public void findAllUsers(){
        Assert.assertEquals(userDao.findAllUsers().size(), 2);
    }
     
    @Test
    public void findByUsername(){
        Assert.assertNotNull(userDao.findByUsername("11111"));
        Assert.assertNull(userDao.findByUsername("14545"));
    }
 
    public User getSampleUser(){
        User employee = new User();
        employee.setName("Karen");
        employee.setUsername("12345");
        employee.setPassword("oh");
        return employee;
    }

}
