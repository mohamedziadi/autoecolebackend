package com.cni.autoecole.services.impl;


import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.CodeEx;
import com.cni.autoecole.entities.repositories.CodeExRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.CodeExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class CodeExServiceImpl implements CodeExService {
	@Autowired
	private CodeExRepository codeExRepository;

	@Override
	public MessageResponse save(CodeEx codeEx) {
		codeEx.setEtat("En attente");
		codeEx.setCreatedAt(new Date());
		codeExRepository.save(codeEx);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(CodeEx codeEx) {
		codeEx.setUpdatedAt(new Date());
		codeExRepository.save(codeEx);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}


	@Override
	public MessageResponse delete(long id) {
		codeExRepository.deleteById(id);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<CodeEx> findAll() {
		return codeExRepository.findAll();
	}



/*@Override
public List<Code> findByInscription(Inscription inscription) {
	// TODO Auto-generated method stub
	return null;
}*/

	@Override
	public List<CodeEx> findByAutoEcole(AutoEcole autoEcole) {
		return codeExRepository.findByAutoEcole(autoEcole);


	}

	@Override
	public List<CodeEx> findByCandidat(Candidat candidat) {
		return codeExRepository.findByCandidat(candidat);
	}

	@Override
	public List<CodeEx> findByEtat(String etat) {
		return codeExRepository.findByEtat(etat);
	}

}