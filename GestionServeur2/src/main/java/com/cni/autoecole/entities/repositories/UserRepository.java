package com.cni.autoecole.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cni.autoecole.entities.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.String;
import java.util.List;

@EnableJpaRepositories(basePackages="ycom.cni.autoecole.entities.repositories", entityManagerFactoryRef="emf")
public interface UserRepository  extends JpaRepository<User, String>{

	List<User> findByEmail(String email);
	List<User> findByUsername(String username);
	
	List<User> findByEmailAndCin(String email,String cin);
	List<User> findByUsernameAndCin(String username,String cin);
}
