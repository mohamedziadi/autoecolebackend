package com.cni.autoecole.entities.repositories;

import com.cni.autoecole.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long>
{
	//List<Seance> findByCandidat(Candidat candidat);

	
}
