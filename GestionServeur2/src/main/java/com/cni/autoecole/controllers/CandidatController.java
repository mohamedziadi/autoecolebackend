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

import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.CandidatService;


@RestController
@RequestMapping("/candidat")
@CrossOrigin("http://localhost:4200")

public class CandidatController {
	@Autowired
	private CandidatService candidatService;

	@PostMapping // save
	public MessageResponse save(@RequestBody Candidat candidat) {

		return candidatService.save(candidat);

	}

	@PutMapping //upadate
	public MessageResponse update(@RequestBody Candidat candidat) {

		return candidatService.update(candidat);

	}

	@DeleteMapping("/{cin}")
	public MessageResponse delete(@PathVariable("cin") String cin) {

		return candidatService.delete(cin);

	}

	@GetMapping
	public List<Candidat> findAll() {
		return candidatService.findAll();
	}
}
