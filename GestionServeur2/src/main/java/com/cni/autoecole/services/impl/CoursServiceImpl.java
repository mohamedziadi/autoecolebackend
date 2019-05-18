package com.cni.autoecole.services.impl;

import java.util.List;

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
	public void save(Cours cours) {
		 coursRepository.save(cours);
		
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
	 return coursRepository.findById(idCrs).get();
	}
	}

	

	

