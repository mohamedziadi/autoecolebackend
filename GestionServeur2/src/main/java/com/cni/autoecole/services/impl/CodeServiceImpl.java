package com.cni.autoecole.services.impl;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cni.autoecole.entities.Code;
import com.cni.autoecole.entities.Inscription;
import com.cni.autoecole.entities.repositories.CodeRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.CodeService;


@Service
@Transactional
public class CodeServiceImpl implements CodeService {
@Autowired
private CodeRepository codeRepository;

@Override
public MessageResponse save(Code code) {
	codeRepository.save(code);
	return new MessageResponse(true, "Opération effectuée avec succès");
}

@Override
public MessageResponse update(Code code) {
    codeRepository.save(code);
	return new MessageResponse(true, "Opération effectuée avec succès");
}


@Override
public MessageResponse delete(long id) {
	codeRepository.deleteById(id);
	return new MessageResponse(true, "Opération effectuée avec succès");
}

@Override
public List<Code> findAll() {
	return codeRepository.findAll();
}

/*@Override
public List<Code> findByInscription(Inscription inscription) {
	// TODO Auto-generated method stub
	return null;
}*/



}

