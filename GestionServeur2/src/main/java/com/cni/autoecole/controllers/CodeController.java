package com.cni.autoecole.controllers;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Code;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
@CrossOrigin("http://localhost:4200")

public class CodeController {
	
	@Autowired
	private CodeService codeService;
	
	
	@PostMapping
public MessageResponse save(@RequestBody Code code) {
		return codeService.save(code);

			}
	
	
	@PutMapping
	public MessageResponse update(@RequestBody Code code) {

		return codeService.update(code);
		 }
	
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable (value = "id") long id){
		 return codeService.delete(id);}

	//public MessageResponse delete(String id) {
		//return null;}
	
	@GetMapping
	public List<Code> findAll(){
		return  codeService.findAll();}
	
   /*@GetMapping("/{id}")
	public List<Code> findAll(@PathVariable("id") long id) {
		Inscription inscription = new Inscription();
		inscription.setId(id);
		return InscriptionService.findByInscription(inscription);
	} */

	@GetMapping("/{idAutoEcole}")
	public List<Code> findAll(@PathVariable("idAutoEcole") long id) {
		AutoEcole autoEcole = new AutoEcole ();
		autoEcole .setId(id);
		return codeService.findByAutoEcole(autoEcole);
	}
	@GetMapping("/candidat/{cin}")
	public List<Code> findAll(@PathVariable("cin") String cin) {
		Candidat candidat = new Candidat ();
		candidat .setCin(cin);
		return codeService.findByCandidat(candidat);
	}

	@GetMapping("/etat/{etat}")
	public List<Code> findByEtat(@PathVariable("etat") String etat) {

		return codeService.findByEtat(etat);
	}
	}
	

