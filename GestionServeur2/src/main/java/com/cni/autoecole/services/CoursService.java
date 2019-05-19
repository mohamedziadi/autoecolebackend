package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Cours;
import com.cni.autoecole.model.MessageResponse;


public interface CoursService {
	Cours save(Cours cours);
	Cours update(Cours cours, long idCrs);
	void delete(long idCrs);
	List<Cours> findAll();
	Cours findCoursById(long idCrs);
	Chapitre addChapitre(Chapitre chapitre,long idCrs);

}
