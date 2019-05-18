package com.cni.autoecole.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cni.autoecole.entities.User;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.model.VerifyPassword;
import com.cni.autoecole.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PutMapping
	public MessageResponse changePassword(@RequestBody VerifyPassword verifyPassword) { // Spring convertira le JSON
																			// publication
		return userService.changePassword(verifyPassword);
	}

	@GetMapping("/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return userService.findByUsername(username);
	}
	
	@GetMapping("/disconnect/{username}")
	public void deconnexion(@PathVariable String username) {
		 userService.deconnect(username);
	}
}
