package com.cni.autoecole.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cni.autoecole.entities.Chapitre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ChapitreRepository extends JpaRepository<Chapitre,Integer>{

    @Query(value = "SELECT chap FROM Chapitre chap where id = :id")
    List<Chapitre> findAllByCoursId(long id);

}
