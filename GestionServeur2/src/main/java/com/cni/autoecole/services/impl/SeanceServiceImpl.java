package com.cni.autoecole.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.autoecole.controllers.SeanceController;
import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.entities.Seance;
import com.cni.autoecole.entities.repositories.CandidatRepository;
import com.cni.autoecole.entities.repositories.MoniteurRepository;
import com.cni.autoecole.entities.repositories.SeanceRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.AutoEcoleService;
import com.cni.autoecole.services.CandidatService;
import com.cni.autoecole.services.SeanceService;

@Service
public class SeanceServiceImpl implements SeanceService{

	@Autowired
	private SeanceRepository seanceRepository;		
	
	
	
	@Override
	public List<Seance> findAll() {
		
		 return (List<Seance>) seanceRepository.findAll();				
	}

	@Override
	public MessageResponse save(Seance seance) {
		seanceRepository.save(seance);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}


	@Override
	public MessageResponse delete(long id) {
		seanceRepository.deleteById(id);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}


	@Override
	public MessageResponse update(Seance seance, long id) {
		seanceRepository.save(seance);
		return new MessageResponse(true, "Opération effectuée avec succès");
		
	}

	@Override
	public List<Seance> findByCandidat(Candidat candidat) {
		return null;
		//return seanceRepository.findByCandidat(candidat);
	}

	

	
		
		
	
			
	}

	

	

