package com.daniel.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.daniel.springsecurity.extra.Photo;


@Repository("photoDao")
public class PhotoDAOImpl extends AbstractDao<Integer, Photo> implements PhotoDAO {

	@Override
	public void addPhoto(Photo p) {
		persist(p);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> listPhotos() {
		Criteria criteria = createEntityCriteria();
        return (List<Photo>) criteria.list();
	}

	@Override
	public Photo getPhotoById(int id) {
		return getByKey(id);
	}

	@Override
	public void removePhoto(int id) {
		// TODO Auto-generated method stub
		
	}



	
	
}