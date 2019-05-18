package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Code;
import com.cni.autoecole.entities.Inscription;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.model.MessageResponse;

public interface CodeService {
	public MessageResponse save(Code code);
	public MessageResponse update(Code code);
	public MessageResponse delete(long id);
	public List<Code> findAll();

	//public List<Code> findByInscription(Inscription inscription);


	
	
	
}
