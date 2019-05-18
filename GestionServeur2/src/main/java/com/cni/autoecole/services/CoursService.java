package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Cours;
import com.cni.autoecole.model.MessageResponse;


public interface CoursService {
	public void save(Cours cours);
	//public MessageResponse save(Cours cours);
	//public MessageResponse update(Cours Cours);
	public Cours update(Cours cours, long idCrs);
	//public MessageResponse delete(int idCrs);
	public void delete(long idCrs);
	public List<Cours> findAll();
	public Cours findCoursById(long idCrs);


}
