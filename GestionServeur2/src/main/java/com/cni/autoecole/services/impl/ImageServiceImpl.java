package com.cni.autoecole.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.autoecole.entities.Image;
import com.cni.autoecole.entities.repositories.ImageRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageRepository imageRepository;

	@Override
	public MessageResponse save(Image image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageResponse delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageResponse update(Image image) {
		// TODO Auto-generated method stub
		return null;
	}

}
