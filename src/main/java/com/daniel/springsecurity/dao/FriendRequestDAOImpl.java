package com.daniel.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daniel.springsecurity.model.extra.FriendRequest;
import com.daniel.springsecurity.model.extra.Post;

@Repository("friendRequestDAO")
public class FriendRequestDAOImpl extends AbstractDao<Integer , FriendRequest> implements FriendRequestDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addFriendRequest(FriendRequest f) {
		getSession().persist(f);
		
	}

	@Override
	public void removeFriendRequest(int id) {
		getSession().delete(id);
		
	}

	@Override
	public List<FriendRequest> findAllByUserId(int userId) {
		Criteria crit = createEntityCriteria();
        Criteria userCriteria = crit.createCriteria("user");
        userCriteria.add(Restrictions.eq("id", userId));
        return (List<FriendRequest>)crit.list();
	}

	@Override
	public List<FriendRequest> listFriendRequests() {
		List<FriendRequest> frList = getSession().createQuery("from FriendRequest").list();
		return frList;
	}

	@Override
	public List<FriendRequest> getFriendRequestsById(int id) {
		Query query = getSession().createQuery("from FriendRequest  where friends_id = :userId").setParameter("userId", id);
		List<FriendRequest> frList = query.list();
		return frList;
	}

}
