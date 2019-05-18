package com.cni.autoecole.controllers;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
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

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.entities.Seance;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.AutoEcoleService;

@RestController
@RequestMapping(value="/auto")
public class AutoEcoleController {
	@Autowired
	private AutoEcoleService autoEcoleService;

	//@PreAuthorize("ROLE_Candidat")
	@GetMapping
	public List<AutoEcole> findAll() {
		// TODO Auto-generated method stub
		return autoEcoleService.findAll();
	}
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable("id") long id) {

		return autoEcoleService.delete(id);

	}
	@PutMapping("/{id}")
	public MessageResponse update(@RequestBody AutoEcole autoEcole ,@PathVariable long id ) {
		return autoEcoleService.save(autoEcole);
		 }
	@PostMapping // save
	public MessageResponse save(@RequestBody AutoEcole autoEcole) {

		return autoEcoleService.save(autoEcole);

}}