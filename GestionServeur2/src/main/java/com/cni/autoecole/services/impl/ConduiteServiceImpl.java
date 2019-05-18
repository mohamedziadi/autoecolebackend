package com.cni.autoecole.services.impl;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cni.autoecole.entities.Conduite;
import com.cni.autoecole.entities.repositories.ConduiteRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ConduiteService;




@Service
@Transactional
public class ConduiteServiceImpl implements ConduiteService {
@Autowired
private ConduiteRepository conduiteRepository;

@Override
public MessageResponse save(Conduite conduite) {
	conduiteRepository.save(conduite);
	return new MessageResponse(true, "Opération effectuée avec succès");
}

@Override
public MessageResponse update(Conduite conduite) {
    conduiteRepository.save(conduite);
	return new MessageResponse(true, "Opération effectuée avec succès");
}




@Override
public List<Conduite> findAll() {
	return conduiteRepository.findAll();
}

@Override
public MessageResponse delete(Long id) {
	conduiteRepository.deleteById(id);
	return new MessageResponse(true, "Opération effectuée avec succès");
}



}

