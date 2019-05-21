package com.cni.autoecole.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.autoecole.entities.Chapitre;
import com.cni.autoecole.entities.Cours;
import com.cni.autoecole.entities.repositories.ChapitreRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ChapitreService;


@Service
public class ChapitreServiceImpl implements ChapitreService{
	@Autowired
	private ChapitreRepository chapitreRepository;

	
	@Override
	public List<Chapitre> findAll() {
		 return (List<Chapitre>) chapitreRepository.findAll();				
	}

	@Override
	
	public Chapitre save(Chapitre chapitre) {
		return chapitreRepository.save(chapitre);
	}

	@Override
	public Chapitre update(Chapitre chapitre, int idChap) {
		Chapitre chapitre1 = chapitreRepository.getOne(idChap);
		chapitre1.setNom(chapitre.getNom());
		chapitre1.setDescription(chapitre.getDescription());

		return 	chapitreRepository.save(chapitre1);
		 }

	
	@Override
	public MessageResponse delete(int idChap) {
		chapitreRepository.deleteById(idChap);
		return null;

	}

    @Override
    public List<Chapitre> getAllByIdCours(long idCrs){

   return  chapitreRepository.findAllByCoursId(idCrs);
    }


}




