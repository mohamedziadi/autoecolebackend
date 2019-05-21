package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Cours;
import com.cni.autoecole.model.MessageResponse;

public interface ChapitreService {
  
	
	 Chapitre save(Chapitre chapitre);
	 Chapitre update(Chapitre chapitre, int idChap);
	 MessageResponse delete(int idChap);
	 List<Chapitre> findAll();
	 List<Chapitre> getAllByIdCours(long idCrs);
	
}
