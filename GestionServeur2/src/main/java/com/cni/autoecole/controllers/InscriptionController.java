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

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Inscription;
import com.cni.autoecole.entities.InscriptionId;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.InscriptionService;

@RestController
@RequestMapping("/inscription")
@CrossOrigin("http://localhost:4200")
public class InscriptionController {

	@Autowired
	public InscriptionService inscriptionService;

	@PostMapping // save
	public MessageResponse save(@RequestBody Inscription inscription) {

		return inscriptionService.save(inscription);

	}

	@PutMapping // upadate
	public MessageResponse update(@RequestBody Inscription inscription) {

		return inscriptionService.update(inscription);

	}

	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable("id") InscriptionId id) {

		return inscriptionService.delete(id);

	}

	@GetMapping("/{idAuto}")
	public List<Inscription> findByAutoEcole(@PathVariable("idAuto") long id) {

		AutoEcole autoEcole = new AutoEcole();
		autoEcole.setId(id);
		return inscriptionService.findByAutoEcole(autoEcole);
	}
	
	@GetMapping("/inscrit/{idAuto}")
	public List<Inscription> findByAutoEcoleConfirm(@PathVariable("idAuto") long id) {

		AutoEcole autoEcole = new AutoEcole();
		autoEcole.setId(id);
		return inscriptionService.findByAutoEcoleAndConfirmed(autoEcole);
	}
}