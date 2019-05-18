package com.cni.autoecole.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class AutoEcole implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
    private String adresse;
	private String horaire;
	private int telephone;
	private  String tarifCode;
	private String tarifConduite;
	

	@JsonIgnore
	@OneToMany(mappedBy = "autoEcole")
	private List<Moniteur> moniteurs;
	@JsonIgnore
	@OneToMany(mappedBy = "autoEcole")
	private List<Secretaire> secretaires;
	@JsonIgnore
	@OneToMany(mappedBy = "autoEcole")
	private List<Inscription> inscriptions;
}