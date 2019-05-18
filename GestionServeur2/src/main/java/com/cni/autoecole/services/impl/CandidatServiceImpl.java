package com.cni.autoecole.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cni.autoecole.controllers.AdminController.*;
import com.cni.autoecole.entities.Admin;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.User;
import com.cni.autoecole.entities.repositories.AdminRepository;
import com.cni.autoecole.entities.repositories.CandidatRepository;
import com.cni.autoecole.entities.repositories.UserRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.model.VerifyPassword;
import com.cni.autoecole.services.AdminService;
import com.cni.autoecole.services.CandidatService;

@Service
public class CandidatServiceImpl implements CandidatService {
	@Autowired
	private CandidatRepository candidatRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public MessageResponse save(Candidat candidat) {

		User user = userRepository.findById(candidat.getCin()).orElse(null);

		if (user != null) {

			return new MessageResponse(false, "CIN existe déja");
		}

		List<User> list = userRepository.findByEmail(candidat.getEmail());
		if (!list.isEmpty()) {
			return new MessageResponse(false, "Email existe déja");
		}
		list = userRepository.findByUsername(candidat.getUsername());
		if (!list.isEmpty()) {
			return new MessageResponse(false, "Nom d'utilisateur existe déja");
		}
		
		
		String password = bCryptPasswordEncoder.encode(candidat.getPassword());
		candidat.setPassword(password);

		candidatRepository.save(candidat);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Candidat candidat) {

		List<User> list = userRepository.findByEmailAndCin(candidat.getEmail(), candidat.getCin());
		if (list.isEmpty()) {
			list = userRepository.findByEmail(candidat.getEmail());
			if (!list.isEmpty()) {
				return new MessageResponse(false, "Email existe déja");
			}
		}
		
		list = userRepository.findByUsernameAndCin(candidat.getUsername(),candidat.getCin());
		if (list.isEmpty()) {
			list = userRepository.findByUsername(candidat.getUsername());
			if (!list.isEmpty()) {
				return new MessageResponse(false, "Nom d'utilisateur existe déja");
			}
		}
	
		candidatRepository.save(candidat);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse delete(String cin) {
	
		User user = userRepository.findById(cin).orElse(null);
		
		if(user.isConnected()) {
			return new MessageResponse(false, "Opération non effectuée: Adminstrateur connecté  ");
		}
		
		candidatRepository.deleteById(cin);
		
		
		
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Candidat> findAll() {
		// TODO Auto-generated method stub
		return candidatRepository.findAll();
	}

	

}
