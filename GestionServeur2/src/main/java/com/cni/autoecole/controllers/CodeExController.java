package com.cni.autoecole.controllers;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.CodeEx;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.CodeExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/codeEx")
@CrossOrigin("http://localhost:4200")

public class CodeExController {
	
	@Autowired
	private CodeExService codeExService;
	
	
	@PostMapping
public MessageResponse save(@RequestBody CodeEx codeEx) {
		return codeExService.save(codeEx);

			}
	
	
	@PutMapping
	public MessageResponse update(@RequestBody CodeEx codeEx) {

		return codeExService.update(codeEx);
		 }
	
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable (value = "id") long id){
		 return codeExService.delete(id);}

	//public MessageResponse delete(String id) {
		//return null;}
	
	@GetMapping
	public List<CodeEx> findAll(){
		return  codeExService.findAll();}
	
   /*@GetMapping("/{id}")
	public List<Code> findAll(@PathVariable("id") long id) {
		Inscription inscription = new Inscription();
		inscription.setId(id);
		return InscriptionService.findByInscription(inscription);
	} */

	@GetMapping("/{idAutoEcole}")
	public List<CodeEx> findAll(@PathVariable("idAutoEcole") long id) {
		AutoEcole autoEcole = new AutoEcole ();
		autoEcole .setId(id);
		return codeExService.findByAutoEcole(autoEcole);
	}
	@GetMapping("/candidat/{cin}")
	public List<CodeEx> findAll(@PathVariable("cin") String cin) {
		Candidat candidat = new Candidat ();
		candidat .setCin(cin);
		return codeExService.findByCandidat(candidat);
	}

	@GetMapping("/etat/{etat}")
	public List<CodeEx> findByEtat(@PathVariable("etat") String etat) {

		return codeExService.findByEtat(etat);
	}
	}
	

