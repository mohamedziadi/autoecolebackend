package com.cni.autoecole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.entities.Secretaire;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.SecretaireService;


@RestController
@RequestMapping("/secretaire")
@CrossOrigin("http://localhost:4200") // fichier de configuration

public class SecretaireController {
	private static final AutoEcole AutoEcole = null;
	@Autowired
	private SecretaireService secretaireService;

	//@PreAuthorize("ROLE_Gerant")
	@PostMapping // save
	public MessageResponse save(@RequestBody Secretaire secretaire) {

		return secretaireService.save(secretaire);

	}
	//@PreAuthorize("ROLE_Gerant")

	@PutMapping //upadate
	public MessageResponse update(@RequestBody Secretaire secretaire) {

		return secretaireService.update(secretaire);

	}



	//@PreAuthorize("ROLE_Gerant")
	@DeleteMapping("/{cin}")
	public MessageResponse delete(@PathVariable("cin") String cin) {

		return secretaireService.delete(cin);

	}
	@GetMapping("/{idAuto}")
	public List<Secretaire> findAll(@PathVariable("idAuto") long id) {
		AutoEcole autoEcole = new AutoEcole();
		autoEcole.setId(id);
		return secretaireService.findByAutoEcole(autoEcole);
	}
}
