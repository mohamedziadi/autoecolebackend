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

import com.cni.autoecole.entities.Admin;
import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Code;
import com.cni.autoecole.entities.Inscription;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.CodeService;
import com.cni.autoecole.services.InscriptionService;

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
	
	
	@PutMapping("/{id}")
	public MessageResponse update(@RequestBody Code code,@PathVariable long id ) {
		return codeService.save(code);
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
	
	}
	

