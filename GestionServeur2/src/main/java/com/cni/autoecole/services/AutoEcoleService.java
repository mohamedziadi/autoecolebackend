package com.cni.autoecole.services;

import java.util.List;
import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.model.MessageResponse;

public interface AutoEcoleService {

	public MessageResponse save(AutoEcole autoEcole);
	public MessageResponse update(AutoEcole autoEcole);

	public List<AutoEcole> findAll();
	public MessageResponse delete(long id);


	
	


}