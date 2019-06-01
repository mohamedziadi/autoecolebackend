package com.cni.autoecole.services.impl;


import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.ConduiteEx;
import com.cni.autoecole.entities.repositories.ConduiteExRepository;
import com.cni.autoecole.model.MessageResponse;

import com.cni.autoecole.services.ConduiteExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class CoduiteExServiceImpl implements ConduiteExService {
	@Autowired
	private ConduiteExRepository conduiteExRepository;

	@Override
	public MessageResponse save(ConduiteEx conduiteEx) {
		conduiteEx.setEtat("En attente");
		conduiteEx.setCreatedAt(new Date());
		conduiteExRepository.save(conduiteEx);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(ConduiteEx conduiteEx) {
		conduiteEx.setUpdatedAt(new Date());
		conduiteExRepository.save(conduiteEx);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}


	@Override
	public MessageResponse delete(long id) {
		conduiteExRepository.deleteById(id);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<ConduiteEx> findAll() {
		return conduiteExRepository.findAll();
	}



/*@Override
public List<ConduiteEx> findByInscription(Inscription inscription) {
	// TODO Auto-generated method stub
	return null;
}*/

	@Override
	public List<ConduiteEx> findByAutoEcole(AutoEcole autoEcole) {
		return conduiteExRepository.findByAutoEcole(autoEcole);


	}

	@Override
	public List<ConduiteEx> findByCandidat(Candidat candidat) {
		return conduiteExRepository.findByCandidat(candidat);
	}

	@Override
	public List<ConduiteEx> findByEtat(String etat) {
		return conduiteExRepository.findByEtat(etat);
	}

}