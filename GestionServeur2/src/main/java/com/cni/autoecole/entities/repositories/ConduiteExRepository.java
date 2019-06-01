package com.cni.autoecole.entities.repositories;

import com.cni.autoecole.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConduiteExRepository extends JpaRepository<ConduiteEx, Long> {

    @Query("select c from ConduiteEx c inner join c.inscription i where i.autoEcole = :auto")
    public List<ConduiteEx> findByAutoEcole(@Param("auto") AutoEcole autoEcole);

    @Query("select c from ConduiteEx c inner join c.inscription i where i.candidat = :candidat")
    public List<ConduiteEx> findByCandidat(@Param("candidat") Candidat candidat);


    public List<ConduiteEx> findByEtat(String etat);
}  
