package com.cni.autoecole.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Entity
@Data
public class Chapitre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idChap;

	private String nom;
	private String description;

	@JsonIgnoreProperties("chapitres")
    @ManyToOne
	private Cours cours;
	@OneToMany(mappedBy = "chapitre")
	private List<Image> images;

}
