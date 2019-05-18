package com.cni.autoecole.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cni.autoecole.controllers.AdminController.*;
import com.cni.autoecole.entities.Admin;
import com.cni.autoecole.entities.User;
import com.cni.autoecole.entities.repositories.AdminRepository;
import com.cni.autoecole.entities.repositories.UserRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.model.VerifyPassword;
import com.cni.autoecole.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public MessageResponse save(Admin admin) {

		User user = userRepository.findById(admin.getCin()).orElse(null);

		if (user != null) {

			return new MessageResponse(false, "CIN existe déja");
		}

		List<User> list = userRepository.findByEmail(admin.getEmail());
		if (!list.isEmpty()) {
			return new MessageResponse(false, "Email existe déja");
		}
		list = userRepository.findByUsername(admin.getUsername());
		if (!list.isEmpty()) {
			return new MessageResponse(false, "Nom d'utilisateur existe déja");
		}
		
		
		String password = bCryptPasswordEncoder.encode(admin.getPassword());
		admin.setPassword(password);

		adminRepository.save(admin);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Admin admin) {

		List<User> list = userRepository.findByEmailAndCin(admin.getEmail(), admin.getCin());
		if (list.isEmpty()) {
			list = userRepository.findByEmail(admin.getEmail());
			if (!list.isEmpty()) {
				return new MessageResponse(false, "Email existe déja");
			}
		}
		
		list = userRepository.findByUsernameAndCin(admin.getUsername(), admin.getCin());
		if (list.isEmpty()) {
			list = userRepository.findByUsername(admin.getUsername());
			if (!list.isEmpty()) {
				return new MessageResponse(false, "Nom d'utilisateur existe déja");
			}
		}
	
		adminRepository.save(admin);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse delete(String cin) {
	
		User user = userRepository.findById(cin).orElse(null);
		
		if(user.isConnected()) {
			return new MessageResponse(false, "Opération non effectuée: Adminstrateur connecté  ");
		}
		
		adminRepository.deleteById(cin);
		
		
		
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	

}
