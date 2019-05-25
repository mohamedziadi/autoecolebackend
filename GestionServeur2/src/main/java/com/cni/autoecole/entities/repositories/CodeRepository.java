package com.cni.autoecole.repositories;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cni.autoecole.entities.Code;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodeRepository extends JpaRepository<Code, Long> {
    @Query("select c from Code c inner join c.inscription i where i.autoEcole = :auto")
    public List<Code> findByAutoEcole(@Param("auto") AutoEcole autoEcole);

    @Query("select c from Code c inner join c.inscription i where i.candidat = :candidat")
    public List<Code> findByCandidat(@Param("candidat") Candidat candidat);


    public List<Code> findByEtat(String etat);
}
