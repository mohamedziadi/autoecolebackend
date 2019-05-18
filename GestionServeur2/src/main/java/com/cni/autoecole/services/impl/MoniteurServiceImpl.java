package com.cni.autoecole.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.entities.User;
import com.cni.autoecole.entities.repositories.MoniteurRepository;
import com.cni.autoecole.entities.repositories.UserRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.model.VerifyPassword;
import com.cni.autoecole.services.AutoEcoleService;
import com.cni.autoecole.services.MoniteurService;

@Service
public class MoniteurServiceImpl implements MoniteurService {
	@Autowired
	private MoniteurRepository moniteurRepository;
	@Autowired
	private AutoEcoleService autoEcoleService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public MessageResponse save(Moniteur moniteur) {

		User user = userRepository.findById(moniteur.getCin()).orElse(null);

		if (user != null) {

			return new MessageResponse(false, "CIN existe déja");
		}

		List<User> list = userRepository.findByEmail(moniteur.getEmail());
		if (!list.isEmpty()) {
			return new MessageResponse(false, "Email existe déja");
		}
		list = userRepository.findByUsername(moniteur.getUsername());
		if (!list.isEmpty()) {
			return new MessageResponse(false, "Nom d'utilisateur existe déja");
		}
		
		
		String password = bCryptPasswordEncoder.encode(moniteur.getPassword());
		moniteur.setPassword(password);
		moniteur.setGerant(false);
		moniteurRepository.save(moniteur);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Moniteur moniteur) {

		List<User> list = userRepository.findByEmailAndCin(moniteur.getEmail(), moniteur.getCin());
		if (list.isEmpty()) {
			list = userRepository.findByEmail(moniteur.getEmail());
			if (!list.isEmpty()) {
				return new MessageResponse(false, "Email existe déja");
			}
		}
		
		list = userRepository.findByUsernameAndCin(moniteur.getUsername(),moniteur.getCin());
		if (list.isEmpty()) {
			list = userRepository.findByUsername(moniteur.getUsername());
			if (!list.isEmpty()) {
				return new MessageResponse(false, "Nom d'utilisateur existe déja");
			}
		}
	
		moniteurRepository.save(moniteur);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse delete(String cin) {
	
		User user = userRepository.findById(cin).orElse(null);
		
		if(user.isConnected()) {
			return new MessageResponse(false, "Opération non effectuée: Adminstrateur connecté  ");
		}
		
		moniteurRepository.deleteById(cin);
		
		
		
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	
	@Override
	public List<Moniteur> findByAutoEcole(AutoEcole autoEcole) {
		// TODO Auto-generated method stub
		return moniteurRepository.findByAutoEcole(autoEcole);
	}

	@Override
	public MessageResponse register(Moniteur moniteur) {
		User user = userRepository.findById(moniteur.getCin()).orElse(null);

		if (user != null) {

			return new MessageResponse(false, "CIN existe déja");
		}

		List<User> list = userRepository.findByEmail(moniteur.getEmail());
		if (!list.isEmpty()) {
			return new MessageResponse(false, "Email existe déja");
		}
		list = userRepository.findByUsername(moniteur.getUsername());
		if (!list.isEmpty()) {
			return new MessageResponse(false, "Nom d'utilisateur existe déja");
		}
		
		
		String password = bCryptPasswordEncoder.encode(moniteur.getPassword());
		moniteur.setPassword(password);
		moniteur.setGerant(true);
		
		autoEcoleService.save(moniteur.getAutoEcole());
		moniteurRepository.save(moniteur);
		
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	

}
