package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.*;
import com.cni.autoecole.model.MessageResponse;

public interface CodeService {

	public MessageResponse save(Code code);
	public MessageResponse update(Code code);
	public MessageResponse delete(long id);
	public List<Code> findAll();
	public List<Code>findByAutoEcole( AutoEcole autoEcole);
	public List<Code>findByCandidat( Candidat candidat);
	public List<Code>findByEtat( String etat);

	//public List<Code> findByInscription(Inscription inscription);

}