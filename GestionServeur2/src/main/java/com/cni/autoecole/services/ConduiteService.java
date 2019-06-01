package com.cni.autoecole.services;

import java.util.List;


import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.ConduiteEx;
import com.cni.autoecole.entities.Conduite;
import com.cni.autoecole.model.MessageResponse;

public interface ConduiteService {

	public MessageResponse save(Conduite conduite);
	public MessageResponse update(Conduite conduite);
	public MessageResponse delete(long id);
	public List<Conduite> findAll();
	public List<Conduite>findByAutoEcole( AutoEcole autoEcole);
	public List<Conduite>findByCandidat( Candidat candidat);
	public List<Conduite>findByEtat( String etat);
	
}
