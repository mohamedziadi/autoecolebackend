package com.cni.autoecole.entities.repositories;

import java.util.List;


import com.cni.autoecole.entities.Code;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cni.autoecole.entities.AutoEcole;
import com.cni.autoecole.model.MessageResponse;

public interface AutoEcoleRepository extends JpaRepository<AutoEcole,Long> {

    //public List<AutoEcole> findByGerant(String gerant);
	


}