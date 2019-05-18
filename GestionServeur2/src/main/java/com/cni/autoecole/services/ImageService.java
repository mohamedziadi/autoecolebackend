package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.Image;
import com.cni.autoecole.model.MessageResponse;

public interface ImageService {

public MessageResponse save(Image image);
public List<Image>findAll();
public  MessageResponse delete(int id);
public MessageResponse update (Image image);
}