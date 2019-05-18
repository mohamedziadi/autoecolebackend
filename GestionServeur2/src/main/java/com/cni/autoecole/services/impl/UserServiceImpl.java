package com.cni.autoecole.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cni.autoecole.entities.User;
import com.cni.autoecole.entities.repositories.UserRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.model.VerifyPassword;
import com.cni.autoecole.services.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override //
	public MessageResponse changePassword(VerifyPassword verifyPassword) {

		User user = userRepository.findById(verifyPassword.getCin()).orElse(null);

		boolean valid = bCryptPasswordEncoder.matches(verifyPassword.getOldPassword(), user.getPassword());

		if (!valid) {
			return new MessageResponse(false, "Ancien mot de passe incorrect");
		}

		String password = bCryptPasswordEncoder.encode(verifyPassword.getNewPassword());
		user.setPassword(password);
		userRepository.save(user);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	
	//marwa benhssine
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<User> list = userRepository.findByUsername(username);

		if (!list.isEmpty())
			return list.get(0);

		return null;
	}

	
	@Override
	public User findByUsername(String username) {
		List<User> list = userRepository.findByUsername(username);

		if (!list.isEmpty()) {
			User user =list.get(0);
			user.setConnected(true);
			userRepository.save(user);
			return list.get(0);
		}
		return null;
	}


	@Override
	public void deconnect(String username) {
		List<User> list = userRepository.findByUsername(username);

		if (!list.isEmpty()) {
			User user =list.get(0);
			user.setConnected(false);
			userRepository.save(user);
		
		}
		
	}

}
