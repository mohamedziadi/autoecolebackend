package com.cni.autoecole.services;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.CodeEx;
import com.cni.autoecole.model.MessageResponse;

import java.util.List;

public interface CodeExService {

	public MessageResponse save(CodeEx codeEx);
	public MessageResponse update(CodeEx codeEx);
	public MessageResponse delete(long id);
	public List<CodeEx> findAll();
	public List<CodeEx>findByAutoEcole(AutoEcole autoEcole);
	public List<CodeEx>findByCandidat(Candidat candidat);
	public List<CodeEx>findByEtat(String etat);

	//public List<Code> findByInscription(Inscription inscription);





}