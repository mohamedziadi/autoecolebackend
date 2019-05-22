
package com.cni.autoecole.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Entity
@Data
public class Cours implements Serializable {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCrs;
	private String description;
	private String nom;

	@JsonIgnoreProperties("cours")
	@OneToMany(mappedBy="cours",cascade = CascadeType.REMOVE)
	private List<Chapitre> chapitres;
	
}
