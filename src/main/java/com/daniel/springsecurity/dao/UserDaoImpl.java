package com.daniel.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.daniel.springsecurity.model.extra.Post;
import com.daniel.springsecurity.model.extra.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findById(int id) {
		return getByKey(id);
	}

	public User findByUsername(String username) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		return (User) crit.uniqueResult();
	}

	@Override
	public void saveUser(User user) {
		persist(user);
		
	}

	@Override
	public void deleteUserByUsername(String username) {
		Query query = getSession().createSQLQuery("delete from Users where username = :username");
        query.setString("username", username);
        query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
	}

	@Override
	public void addPost(Post post) {
				
	}

	@Override
	public int findIdByUsername(String username) {
		Query query = getSession().createQuery("from User where username = :username").setParameter("username", username);
		User user = (User) query.uniqueResult();
		int result = user.getId();
		return result;
	}

	
}
