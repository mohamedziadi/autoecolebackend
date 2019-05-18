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

import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Examen;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ExamenService;

@RestController
@RequestMapping("/examen")
@CrossOrigin("http://localhost:4200")
public class ExamenController {
	@Autowired
	private ExamenService examenService;
	
	
	@PostMapping
public void save(@RequestBody Examen examen) {
		examenService.save(examen);}

	//public MessageResponse save(Examen exmane) {
		//return null;}
	
	
 @GetMapping
	public List<Examen> findALL(){
	 return  examenService.findAll();
 }
 

@PutMapping("/modif/{id}")
public void update(@RequestBody Examen examen,@PathVariable int id ) {
	//{chapitre.setCours(new Cours(id,"ee","ee"));
	examenService.update(examen,id);
	 }
// public MessageResponse update(Examen examen) {
	 //return null;}
 
 
 
@DeleteMapping("/delete/{id}")
 
 public void delete(@PathVariable (value = "id") long id){
	 examenService.delete(id);}
//public MessageResponse delete(long id) {
	 //  return null;}
 
 
}

