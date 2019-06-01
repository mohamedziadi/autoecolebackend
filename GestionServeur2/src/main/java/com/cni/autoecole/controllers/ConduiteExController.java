package com.cni.autoecole.controllers;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.ConduiteEx;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ConduiteExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conduiteEx")
@CrossOrigin("http://localhost:4200")

public class ConduiteExController {
	
	@Autowired
	private ConduiteExService conduiteExService;
	
	
	@PostMapping
public MessageResponse save(@RequestBody ConduiteEx conduiteEx) {
		return conduiteExService.save(conduiteEx);

			}
	
	
	@PutMapping
	public MessageResponse update(@RequestBody ConduiteEx conduiteEx) {

		return conduiteExService.update(conduiteEx);
		 }
	
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable (value = "id") long id){
		 return conduiteExService.delete(id);}

	//public MessageResponse delete(String id) {
		//return null;}
	
	@GetMapping
	public List<ConduiteEx> findAll(){
		return  conduiteExService.findAll();}
	
   /*@GetMapping("/{id}")
	public List<ConduiteEx> findAll(@PathVariable("id") long id) {
		Inscription inscription = new Inscription();
		inscription.setId(id);
		return InscriptionService.findByInscription(inscription);
	} */

	@GetMapping("/{idAutoEcole}")
	public List<ConduiteEx> findAll(@PathVariable("idAutoEcole") long id) {
		AutoEcole autoEcole = new AutoEcole ();
		autoEcole .setId(id);
		return conduiteExService.findByAutoEcole(autoEcole);
	}
	@GetMapping("/candidat/{cin}")
	public List<ConduiteEx> findAll(@PathVariable("cin") String cin) {
		Candidat candidat = new Candidat ();
		candidat .setCin(cin);
		return conduiteExService.findByCandidat(candidat);
	}

	@GetMapping("/etat/{etat}")
	public List<ConduiteEx> findByEtat(@PathVariable("etat") String etat) {

		return conduiteExService.findByEtat(etat);
	}
	}
	

