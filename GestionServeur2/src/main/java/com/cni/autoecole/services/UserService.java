package com.cni.autoecole.services;

import com.cni.autoecole.entities.User;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.model.VerifyPassword;

public interface UserService {
	public MessageResponse changePassword(VerifyPassword verifyPassword);
	public User findByUsername(String username);
	public void deconnect(String username);
	
}
