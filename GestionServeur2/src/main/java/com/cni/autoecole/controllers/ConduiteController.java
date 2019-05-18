package com.cni.autoecole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Conduite;

import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ConduiteService;


@RestController
@RequestMapping("/conduite")
@CrossOrigin("http://localhost:4200")

public class ConduiteController {
	
	@Autowired
	private ConduiteService conduiteService;
	
	
	@PostMapping
public MessageResponse save(@RequestBody Conduite conduite) {
		return conduiteService.save(conduite);

			}
	
	
	@PutMapping("/{id}")
	public MessageResponse update(@RequestBody Conduite conduite,@PathVariable long id ) {
		return conduiteService.update(conduite);
		 }
	
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable (value = "id") long id){
		 return conduiteService.delete(id);}

	//public MessageResponse delete(String id) {
		//return null;}
	
	@GetMapping
	public List<Conduite> findAll(){
		return  conduiteService.findAll();}
	
	
	}
	

