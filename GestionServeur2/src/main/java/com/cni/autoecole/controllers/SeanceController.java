package com.cni.autoecole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.entities.Seance;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.SeanceService;


@RestController
@RequestMapping("/seance")
@CrossOrigin("http://localhost:4200")

public class SeanceController {
	
	@Autowired
	private SeanceService seanceService;
	
	
	@PostMapping
public MessageResponse save(@RequestBody Seance seance) {
		return seanceService.save(seance);

			}
	
	
	@PutMapping("/{id}")
	public MessageResponse update(@RequestBody Seance seance,@PathVariable long id ) {
		return seanceService.update(seance,id);
		 }
	
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable (value = "id") long id){
		 return seanceService.delete(id);}

	//public MessageResponse delete(String id) {
		//return null;}
	
	@GetMapping
	public List<Seance> findAll(){
		return  seanceService.findAll();}
	
	@GetMapping("/{idCandidat}")
	public List<Seance> findAll(@PathVariable("idCandidat") String cin) {
		Candidat candidat = new Candidat();
		candidat.setCin(cin);
		return seanceService.findByCandidat(candidat);
	}
	}
	

