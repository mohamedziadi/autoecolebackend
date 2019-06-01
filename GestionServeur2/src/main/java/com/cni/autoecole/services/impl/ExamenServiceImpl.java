package com.cni.autoecole.services.impl;

import java.util.List;

import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Seance;
import com.cni.autoecole.entities.repositories.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.autoecole.entities.Examen;
import com.cni.autoecole.entities.repositories.ExamenRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService {
@Autowired 
private ExamenRepository examenRepository;


	@Override
	public List<Examen> findAll() {

		return (List<Examen>) examenRepository.findAll();
	}

	@Override
	public MessageResponse save(Examen examen) {
		examenRepository.save(examen);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}


	@Override
	public MessageResponse delete(long id) {
		examenRepository.deleteById(id);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}


	@Override
	public MessageResponse update(Examen examen, long id) {
		examenRepository.save(examen);
		return new MessageResponse(true, "Opération effectuée avec succès");

	}

	@Override
	public List<Examen> findByCandidat(Examen examen) {
		return null;
	}
}










