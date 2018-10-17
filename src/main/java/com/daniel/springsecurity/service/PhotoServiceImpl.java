package com.daniel.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.springsecurity.dao.PhotoDAO;
import com.daniel.springsecurity.extra.Photo;

@Service
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired
	private PhotoDAO photoDAO;

	@Override
	@Transactional
	public void addPhoto(Photo p) {
		photoDAO.addPhoto(p);
	}

	@Override
	@Transactional
	public List<Photo> listPhotos() {
		return photoDAO.listPhotos();
	}

	@Override
	@Transactional
	public Photo getPhotoById(int id) {
		return photoDAO.getPhotoById(id);
	}

	@Override
	@Transactional
	public void removePhoto(int id) {
		photoDAO.removePhoto(id);
	}

}
