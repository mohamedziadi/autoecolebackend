package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Cours;
import com.cni.autoecole.model.MessageResponse;

public interface ChapitreService {
  
	
	public MessageResponse save(Chapitre chapitre);
	public MessageResponse update(Chapitre chapitre, int idChap);
	public MessageResponse delete(int idChap);
	public List<Chapitre> findAll();
	
}
