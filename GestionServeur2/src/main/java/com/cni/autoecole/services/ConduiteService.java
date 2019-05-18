package com.cni.autoecole.services;

import java.util.List;


import com.cni.autoecole.entities.Conduite;
import com.cni.autoecole.model.MessageResponse;

public interface ConduiteService {

	public MessageResponse save(Conduite conduite);
	public MessageResponse update(Conduite conduite);
	public MessageResponse delete(Long id);
	public List<Conduite> findAll();

	
}
