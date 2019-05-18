package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.Admin;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.model.VerifyPassword;

public interface AdminService {
	
	public MessageResponse save(Admin admin);
	public MessageResponse update(Admin admin);
	public MessageResponse delete(String cin);
	public List<Admin> findAll();

	
	


}
