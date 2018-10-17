package com.daniel.springsecurity.service;

import java.util.List;

import com.daniel.springsecurity.extra.Photo;

public interface PhotoService {

	public void addPhoto(Photo p);
	public List<Photo> listPhotos();
	public Photo getPhotoById(int id);
	public void removePhoto(int id);
	
}

