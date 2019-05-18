package com.cni.autoecole.services;

import java.util.List;

import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.model.MessageResponse;

public interface CandidatService {
public MessageResponse save(Candidat candidat);
public MessageResponse update(Candidat candidat);
public MessageResponse delete(String cin);
public List<Candidat> findAll();
}
