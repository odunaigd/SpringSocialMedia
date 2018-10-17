package com.daniel.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daniel.springsecurity.model.extra.Friend;


@Repository("friendDao")
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session getSession(){
		
			return sessionFactory.getCurrentSession();
	
	}



	
	public void removeFriend(int id) {
		getSession().delete(id);
		
	}

	
	@SuppressWarnings("unchecked")
	public List<Friend> listFriends() {
		List<Friend> fList = getSession().createQuery("from Friend").list();
		return fList;
	}



	@SuppressWarnings("unchecked")
	public List<Friend> getFriendsById(int id) {
		Query query = getSession().createQuery("from Friend where friend_id =:userid").setParameter("userid", id);
		List<Friend> fList = query.list();
		return fList;
	}




	@Override
	public void addFriend(Friend f) {
		getSession().persist(f);
		
	}




	@Override
	public Friend getFriendById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}