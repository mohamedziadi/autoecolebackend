package com.cni.autoecole.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Inscription;
import com.cni.autoecole.entities.InscriptionId;
import com.cni.autoecole.entities.repositories.InscriptionRepository;
import com.cni.autoecole.model.MessageResponse;
import com.cni.autoecole.services.InscriptionService;

@Service
public class InscriptionServiceImpl implements InscriptionService {

	@Autowired
	private InscriptionRepository inscriptionRepository;

	@Override
	public MessageResponse save(Inscription inscription) {

		InscriptionId id = new InscriptionId();
		id.setCinCandidat(inscription.getCandidat().getCin());
		id.setIdAutoEcole(inscription.getAutoEcole().getId());
		inscription.setId(id);

		Inscription inscri =inscriptionRepository.findById(id).orElse(null);
		if(inscri !=null) {
			return new MessageResponse(false, "Vous etes deja inscrit");
		}
		inscription.setConfirmed(false);
		inscription.setDate(new Date());
		inscriptionRepository.save(inscription);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Inscription inscription) {
		inscriptionRepository.save(inscription);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse delete(InscriptionId id) {
		inscriptionRepository.deleteById(id);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Inscription> findByAutoEcole(AutoEcole autoEcole) {
		return inscriptionRepository.findByAutoEcole(autoEcole);
	}

	@Override
	public List<Inscription> findByAutoEcoleAndConfirmed(AutoEcole autoEcole) {
		// TODO Auto-generated method stub
		return inscriptionRepository.findByAutoEcoleAndConfirmed(autoEcole, true);
	}

}