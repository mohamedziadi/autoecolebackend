package com.cni.autoecole.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.CandidatService;
import com.cni.autoecole.services.MoniteurService;

@RestController
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private CandidatService candidatService;
	@Autowired
	
	
	private MoniteurService moniteurService;
	
	@PostMapping
	public MessageResponse register(@RequestBody Candidat candidat) {
		return candidatService.save(candidat);
	}
		
	@PostMapping("/autoEcole")
	public MessageResponse register(@RequestBody Moniteur moniteur) {
		
		return moniteurService.register(moniteur);
	}
}
