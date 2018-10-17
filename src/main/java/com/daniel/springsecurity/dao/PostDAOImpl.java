package com.daniel.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.daniel.springsecurity.model.extra.Post;
import com.daniel.springsecurity.model.extra.User;


@Repository("postDao")
public class PostDAOImpl extends AbstractDao<Integer, Post> implements PostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}



	
	public void removePost(int id) {
		getSession().delete(id);
		
	}

	
	@SuppressWarnings("unchecked")
	public List<Post> listPosts() {
		List<Post> postsList = getSession().createQuery("from Post").list();
		return postsList;
	}

	
	public Post getPostById(int id) {
		return null;
	}


	@SuppressWarnings("unchecked")
	public List<Post> getPostsById(int id) {
		
		Query query = getSession().createQuery("from Post where user_id =:user_id").setParameter("user_id", id); 
		List<Post> pList = query.list();
		return pList;
	}

	
	@SuppressWarnings("unchecked")
	public void addPost(Post p) {
		/*Query query = getSession().createQuery("select p.userId from Post p where p.username = :username").setParameter("username", uname);
		List<String> un = query.list();*/
		getSession().persist(p);
		
	}

	@SuppressWarnings("unchecked")
    public List<Post> findAllByUserId(int userId){
        Criteria crit = createEntityCriteria();
        Criteria userCriteria = crit.createCriteria("user");
        userCriteria.add(Restrictions.eq("id", userId));
        return (List<Post>)crit.list();
    }
	

}