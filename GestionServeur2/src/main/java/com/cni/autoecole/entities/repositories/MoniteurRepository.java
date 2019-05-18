package com.cni.autoecole.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Moniteur;

public interface MoniteurRepository extends JpaRepository<Moniteur,String>{

	List<Moniteur> findByAutoEcole(AutoEcole autoEcole);

}
