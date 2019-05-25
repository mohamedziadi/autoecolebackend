package com.cni.autoecole.services.impl;



import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.autoecole.entities.Code;
import com.cni.autoecole.repositories.CodeRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.CodeService;


@Service
@Transactional
public class CodeServiceImpl  implements CodeService {
	@Autowired
	private CodeRepository codeRepository;

	@Override
	public MessageResponse save(Code code) {
		code.setEtat("En attente");
		code.setCreatedAt(new Date());
		codeRepository.save(code);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Code code) {
		code.setUpdatedAt(new Date());
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

	@Override
	public List<Code> findByAutoEcole(AutoEcole autoEcole) {
		return codeRepository.findByAutoEcole(autoEcole);


	}

	@Override
	public List<Code> findByCandidat(Candidat candidat) {
		return codeRepository.findByCandidat(candidat);
	}

	@Override
	public List<Code> findByEtat(String etat) {
		return codeRepository.findByEtat(etat);
	}

}