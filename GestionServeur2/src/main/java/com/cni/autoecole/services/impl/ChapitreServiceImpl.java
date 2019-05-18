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
	
	public MessageResponse save(Chapitre chapitre) {
		 chapitreRepository.save(chapitre);
		return null;
	}

	@Override
	public MessageResponse update(Chapitre chapitre, int idChap) {
		chapitreRepository.save(chapitre);
		return null;
		 }

	
	@Override
	public MessageResponse delete(int idChap) {
		chapitreRepository.deleteById(idChap);
		return null;

	}
		
	}




