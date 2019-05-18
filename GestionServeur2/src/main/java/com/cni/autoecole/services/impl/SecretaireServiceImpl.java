package com.cni.autoecole.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Secretaire;
import com.cni.autoecole.entities.User;
import com.cni.autoecole.entities.repositories.SecretaireRepository;
import com.cni.autoecole.entities.repositories.UserRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.model.VerifyPassword;
import com.cni.autoecole.services.SecretaireService;


@Service
public class SecretaireServiceImpl implements SecretaireService {
	@Autowired
	private SecretaireRepository secretaireRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public MessageResponse save(Secretaire secretaire) {

		User user = userRepository.findById(secretaire.getCin()).orElse(null);

		if (user != null) {

			return new MessageResponse(false, "CIN existe déja");
		}

		List<User> list = userRepository.findByEmail(secretaire.getEmail());
		if (!list.isEmpty()) {
			return new MessageResponse(false, "Email existe déja");
		}
		list = userRepository.findByUsername(secretaire.getUsername());
		if (!list.isEmpty()) {
			return new MessageResponse(false, "Nom d'utilisateur existe déja");
		}
		
		
		String password = bCryptPasswordEncoder.encode(secretaire.getPassword());
		secretaire.setPassword(password);

		secretaireRepository.save(secretaire);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Secretaire secretaire) {

		List<User> list = userRepository.findByEmailAndCin(secretaire.getEmail(), secretaire.getCin());
		if (list.isEmpty()) {
			list = userRepository.findByEmail(secretaire.getEmail());
			if (!list.isEmpty()) {
				return new MessageResponse(false, "Email existe déja");
			}
		}
		
		list = userRepository.findByUsernameAndCin(secretaire.getUsername(), secretaire.getCin());
		if (list.isEmpty()) {
			list = userRepository.findByUsername(secretaire.getUsername());
			if (!list.isEmpty()) {
				return new MessageResponse(false, "Nom d'utilisateur existe déja");
			}
		}
	
		secretaireRepository.save(secretaire);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse delete(String cin) {
	
		User user = userRepository.findById(cin).orElse(null);
		
		if(user.isConnected()) {
			return new MessageResponse(false, "Opération non effectuée: Secretairestrateur connecté  ");
		}
		
		secretaireRepository.deleteById(cin);
		
		
		
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Secretaire> findByAutoEcole(AutoEcole autoEcole) {
		// TODO Auto-generated method stub
		return secretaireRepository.findByAutoEcole(autoEcole);
	}


	

}
