package com.cni.autoecole.entities.repositories;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.Conduite;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cni.autoecole.entities.Conduite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConduiteRepository extends JpaRepository<Conduite, Long> {

    @Query("select c from Conduite c inner join c.inscription i where i.autoEcole = :auto")
    public List<Conduite> findByAutoEcole(@Param("auto") AutoEcole autoEcole);

    @Query("select c from Conduite c inner join c.inscription i where i.candidat = :candidat")
    public List<Conduite> findByCandidat(@Param("candidat") Candidat candidat);


    public List<Conduite> findByEtat(String etat);
}  

