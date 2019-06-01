package com.cni.autoecole.controllers;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
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
	
	
	@PutMapping
	public MessageResponse update(@RequestBody Conduite conduite) {

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
	
   /*@GetMapping("/{id}")
	public List<Conduite> findAll(@PathVariable("id") long id) {
		Inscription inscription = new Inscription();
		inscription.setId(id);
		return InscriptionService.findByInscription(inscription);
	} */

	@GetMapping("/{idAutoEcole}")
	public List<Conduite> findAll(@PathVariable("idAutoEcole") long id) {
		AutoEcole autoEcole = new AutoEcole ();
		autoEcole .setId(id);
		return conduiteService.findByAutoEcole(autoEcole);
	}
	@GetMapping("/candidat/{cin}")
	public List<Conduite> findAll(@PathVariable("cin") String cin) {
		Candidat candidat = new Candidat ();
		candidat .setCin(cin);
		return conduiteService.findByCandidat(candidat);
	}

	@GetMapping("/etat/{etat}")
	public List<Conduite> findByEtat(@PathVariable("etat") String etat) {

		return conduiteService.findByEtat(etat);
	}
	}
	

