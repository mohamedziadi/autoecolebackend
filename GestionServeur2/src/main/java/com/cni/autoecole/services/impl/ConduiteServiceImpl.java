package com.cni.autoecole.services.impl;


import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Conduite;
import com.cni.autoecole.entities.repositories.ConduiteRepository;
import com.cni.autoecole.model.MessageResponse;

import com.cni.autoecole.services.ConduiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class ConduiteServiceImpl implements ConduiteService {
	@Autowired
	private ConduiteRepository conduiteRepository;

	@Override
	public MessageResponse save(Conduite conduite) {
		conduite.setEtat("En attente");
		conduite.setCreatedAt(new Date());
		conduiteRepository.save(conduite);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Conduite conduite) {
		conduite.setUpdatedAt(new Date());
		conduiteRepository.save(conduite);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}


	@Override
	public MessageResponse delete(long id) {
		conduiteRepository.deleteById(id);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Conduite> findAll() {
		return conduiteRepository.findAll();
	}



/*@Override
public List<Conduite> findByInscription(Inscription inscription) {
	// TODO Auto-generated method stub
	return null;
}*/

	@Override
	public List<Conduite> findByAutoEcole(AutoEcole autoEcole) {
		return conduiteRepository.findByAutoEcole(autoEcole);


	}

	@Override
	public List<Conduite> findByCandidat(Candidat candidat) {
		return conduiteRepository.findByCandidat(candidat);
	}

	@Override
	public List<Conduite> findByEtat(String etat) {
		return conduiteRepository.findByEtat(etat);
	}

}