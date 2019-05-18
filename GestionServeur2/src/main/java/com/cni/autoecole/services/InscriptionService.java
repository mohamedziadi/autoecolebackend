package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.Admin;
import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Inscription;
import com.cni.autoecole.entities.InscriptionId;
import com.cni.autoecole.model.MessageResponse;

public interface InscriptionService {
	public MessageResponse save(Inscription inscription);
	public MessageResponse update(Inscription inscription);
	public MessageResponse delete(InscriptionId id);

	List<Inscription> findByAutoEcole(AutoEcole autoEcole);
	List<Inscription> findByAutoEcoleAndConfirmed(AutoEcole autoEcole);
}
