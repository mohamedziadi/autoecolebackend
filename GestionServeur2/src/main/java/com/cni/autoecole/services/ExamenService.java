package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.Admin;
import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Examen;
import com.cni.autoecole.model.MessageResponse;

public interface ExamenService {
	//public MessageResponse save(Examen examen);
	//public MessageResponse update(Examen examen);
	//public MessageResponse delete(String id);
	public List<Examen> findAll();
	public void save(Examen examen);
	public void update(Examen examen, long id);
	public void delete(long id);

}
