package com.cni.autoecole.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Inscription;
import com.cni.autoecole.entities.InscriptionId;

public interface InscriptionRepository extends JpaRepository<Inscription,InscriptionId> {

	List<Inscription> findByAutoEcole(AutoEcole autoEcole);
	List<Inscription> findByAutoEcoleAndConfirmed(AutoEcole autoEcole, boolean confirm);
}
