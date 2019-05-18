package com.cni.autoecole.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cni.autoecole.entities.Admin;
import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Moniteur;
import com.cni.autoecole.entities.Secretaire;

public interface SecretaireRepository  extends JpaRepository<Secretaire, String>{
	List<Secretaire> findByAutoEcole(AutoEcole autoEcole);

}
