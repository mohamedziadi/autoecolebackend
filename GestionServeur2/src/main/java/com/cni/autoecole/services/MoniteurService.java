package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.model.VerifyPassword;

public interface MoniteurService {
	
	public MessageResponse save(Moniteur moniteur);
	public MessageResponse register(Moniteur moniteur);
	public MessageResponse update(Moniteur moniteur);
	public MessageResponse delete(String cin);
	public List<Moniteur> findByAutoEcole(AutoEcole autoEcole);

}
	
