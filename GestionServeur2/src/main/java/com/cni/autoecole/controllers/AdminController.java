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

import com.cni.autoecole.entities.Admin;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200") // fichier de configuration

public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping // save
	public MessageResponse save(@RequestBody Admin admin) {

		return adminService.save(admin);

	}

	@PutMapping // upadate
	public MessageResponse update(@RequestBody Admin admin) {

		return adminService.update(admin);

	}


	@DeleteMapping("/{cin}")
	public MessageResponse delete(@PathVariable("cin") String cin) {

		return adminService.delete(cin);

	}


	@GetMapping
	public List<Admin> findAll() {
		return adminService.findAll();
	}
}
