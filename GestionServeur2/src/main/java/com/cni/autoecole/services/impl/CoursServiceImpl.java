package com.cni.autoecole.services.impl;

import java.util.Arrays;
import java.util.List;

import com.cni.autoecole.entities.Chapitre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cni.autoecole.entities.Cours;
import com.cni.autoecole.entities.repositories.CoursRepository;

import com.cni.autoecole.services.CoursService;


@Service
public class CoursServiceImpl implements CoursService{

	@Autowired
	private CoursRepository coursRepository;

	@Override
	//public MessageResponse save cours(Cours cours) {}
	public Cours save(Cours cours) {
	return	 coursRepository.save(cours);

	}

	@Override
	public Cours update(Cours cours, long idCrs) {
		Cours cours1 = coursRepository.getOne(idCrs);
		cours1.setNom(cours.getNom());
		cours1.setDescription(cours.getDescription());

	return 	coursRepository.save(cours1);
		 }


	@Override
	public void delete(long id) {
		coursRepository.deleteById(id);

		}

	@Override
	public List<Cours> findAll() {
		 return (List<Cours>) coursRepository.findAll();		
	}

	@Override
	public Cours findCoursById(long idCrs){
	    Cours cours = getCours(idCrs);

        return cours;
	}

	@Override
	public Chapitre addChapitre(Chapitre chapitre, long idCrs){
		Cours cours = getCours(idCrs);
		if (cours.getChapitres().isEmpty()) {
			cours.setChapitres(Arrays.asList(chapitre));
		} else {
			cours.getChapitres().add(chapitre);
		}
		coursRepository.save(cours);
		return chapitre;
	}

	private Cours getCours(long idCrs) {
		Cours cours =  new Cours();
		cours.setIdCrs(coursRepository.getOne(idCrs).getIdCrs());
		cours.setNom(coursRepository.getOne(idCrs).getNom());
		cours.setDescription(coursRepository.getOne(idCrs).getDescription());
		cours.setChapitres(coursRepository.getOne(idCrs).getChapitres());
		return cours;
	}
}



	

