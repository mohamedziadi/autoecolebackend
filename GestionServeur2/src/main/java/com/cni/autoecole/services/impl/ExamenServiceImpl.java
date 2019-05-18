package com.cni.autoecole.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.autoecole.entities.Examen;
import com.cni.autoecole.entities.repositories.ExamenRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService {
@Autowired 
private ExamenRepository examenRepository;

//@Override
//public MessageResponse save(Examen examen) {
	//return null;}

//@Override
//public MessageResponse update(Examen examen) {
	// TODO Auto-generated method stub
	//return null;}


//@Override
//public MessageResponse delete(String id) {
	// TODO Auto-generated method stub
	//return null;}


@Override
public List<Examen> findAll() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void save(Examen examen) {
	examenRepository.save(examen);
}

@Override
public void update(Examen examen, long id) {
	examenRepository.save(examen);
}

@Override
public void delete(long id) {
	examenRepository.deleteById(id);
	
}
    

}
