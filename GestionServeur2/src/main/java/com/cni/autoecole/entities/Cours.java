
package com.cni.autoecole.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Cours implements Serializable {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCrs;
	private String description;
	private String nom;
	@OneToMany(mappedBy="cours")
	private List<Chapitre> chapitres;
	
}
