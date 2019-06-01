package com.cni.autoecole.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.cni.autoecole.entities.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Cours;
import com.cni.autoecole.entities.repositories.AutoEcoleRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.AutoEcoleService;


@Service
@Transactional
public class AutoEcoleServiceImpl implements AutoEcoleService {
@Autowired
private AutoEcoleRepository autoEcoleRepository;

@Override
public MessageResponse save(AutoEcole autoEcole) {
	autoEcoleRepository.save(autoEcole);
	return new MessageResponse(true, "Opération effectuée avec succès");
}

@Override
public MessageResponse update(AutoEcole autoEcole) {
	autoEcoleRepository.save(autoEcole);
	return new MessageResponse(true, "Opération effectuée avec succès");
}

@Override
public MessageResponse delete(long id) {
	autoEcoleRepository.deleteById(id);
	return new MessageResponse(true, "Opération effectuée avec succès");
}

	/*@Override
	public List<AutoEcole> findByGerant(Boolean gerant) {
		return null;
	}*/


	@Override
public List<AutoEcole> findAll() {
	// TODO Auto-generated method stub
	return autoEcoleRepository.findAll();


}





}
