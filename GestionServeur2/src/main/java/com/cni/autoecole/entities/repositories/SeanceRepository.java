package com.cni.autoecole.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cni.autoecole.entities.Candidat;

import com.cni.autoecole.entities.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Long>
{
	//List<Seance> findByCandidat(Candidat candidat);

	
}
