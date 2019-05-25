package com.cni.autoecole.controllers;

import com.cni.autoecole.entities.Conduite;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ConduiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
	

