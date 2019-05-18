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
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.MoniteurService;

@RestController
@RequestMapping("/moniteur")
@CrossOrigin("http://localhost:4200")

public class MoniteurController {
	@Autowired
	private MoniteurService moniteurService;

	//@PreAuthorize("ROLE_Gerant")
	@PostMapping // save
	public MessageResponse save(@RequestBody Moniteur moniteur) {

		return moniteurService.save(moniteur);

	}
	@PreAuthorize("ROLE_Gerant")
	@PutMapping // upadate
	public MessageResponse update(@RequestBody Moniteur moniteur) {

		return moniteurService.update(moniteur);

	}
	@PreAuthorize("ROLE_Gerant")
	@DeleteMapping("/{cin}")
	public MessageResponse delete(@PathVariable("cin") String cin) {

		return moniteurService.delete(cin);

	}
	
	@GetMapping("/{idAuto}")
	public List<Moniteur> findAll(@PathVariable("idAuto") long id) {
		AutoEcole autoEcole = new AutoEcole();
		autoEcole.setId(id);
		return moniteurService.findByAutoEcole(autoEcole);
	}
	
}
