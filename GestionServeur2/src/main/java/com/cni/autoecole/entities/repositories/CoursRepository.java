package com.cni.autoecole.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cni.autoecole.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours,Long> {

}
