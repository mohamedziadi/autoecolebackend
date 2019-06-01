package com.cni.autoecole.services;

import com.cni.autoecole.entities.*;
import com.cni.autoecole.model.MessageResponse;

import java.util.List;

public interface ConduiteExService {


	public MessageResponse save(ConduiteEx conduiteEx);
	public MessageResponse update(ConduiteEx conduiteEx);
	public MessageResponse delete(long id);
	public List<ConduiteEx> findAll();
	public List<ConduiteEx>findByAutoEcole(AutoEcole autoEcole);
	public List<ConduiteEx>findByCandidat(Candidat candidat);
	public List<ConduiteEx>findByEtat(String etat);



}
