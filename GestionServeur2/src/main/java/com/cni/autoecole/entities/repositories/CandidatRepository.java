package com.cni.autoecole.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cni.autoecole.entities.Candidat;

public interface CandidatRepository extends JpaRepository <Candidat,String> {

	

	
}