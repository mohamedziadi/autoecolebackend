package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.controllers.SeanceController;
import com.cni.autoecole.entities.Admin;
import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.entities.Seance;
import com.cni.autoecole.model.MessageResponse;

public interface SeanceService {
	
	

	public MessageResponse save(Seance seance);
	public MessageResponse delete(long id);
	public List<Seance> findAll();
	public MessageResponse update(Seance seance, long id);
	public List<Seance> findByCandidat(Candidat candidat);

	
}
