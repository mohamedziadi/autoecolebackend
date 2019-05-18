package com.cni.autoecole.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cni.autoecole.entities.Image;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ImageService;

@RestController
@RequestMapping
@CrossOrigin("http://localhost:400")
public class ImageController {
	
	@Autowired
	public ImageService imageService;

	@PostMapping
	public MessageResponse save (Image image) {
		return null;
	}
	
	@PutMapping
	public MessageResponse update(Image image) {
		return null;}
   @GetMapping
   public List<Image> findAll(){
	   return null;
   }
	   @DeleteMapping
	   public MessageResponse delete(int id) {
		   return null;
	   }
   }
