package com.daniel.springsecurity.dao;

import java.util.List;

import com.daniel.springsecurity.extra.Photo;

public interface PhotoDAO {

	void addPhoto(Photo p);

	List<Photo> listPhotos();

	Photo getPhotoById(int id);

	void removePhoto(int id);

}
