package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.*;
import com.cni.autoecole.model.MessageResponse;

public interface ExamenService {
	public MessageResponse save(Examen examen);
	public MessageResponse delete(long id);
	public List<Examen> findAll();
	public MessageResponse update(Examen examen, long id);
	public List<Examen> findByCandidat(Examen examen);
}
