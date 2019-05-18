package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Secretaire;
import com.cni.autoecole.model.MessageResponse;

public interface SecretaireService {
	
	public MessageResponse save(Secretaire secretaire);
	public MessageResponse update(Secretaire secretaire);
	public MessageResponse delete(String cin);
	public List<Secretaire> findByAutoEcole(AutoEcole autoEcole);

	
	


}
