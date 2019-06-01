package com.cni.autoecole.entities.repositories;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.entities.Candidat;
import com.cni.autoecole.entities.CodeEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodeExRepository extends JpaRepository<CodeEx, Long> {
    @Query("select c from Code c inner join c.inscription i where i.autoEcole = :auto")
    public List<CodeEx> findByAutoEcole(@Param("auto") AutoEcole autoEcole);

    @Query("select c from Code c inner join c.inscription i where i.candidat = :candidat")
    public List<CodeEx> findByCandidat(@Param("candidat") Candidat candidat);


    public List<CodeEx> findByEtat(String etat);
}
