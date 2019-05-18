   package com.cni.autoecole.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Candidat extends User implements Serializable {
	@JsonIgnore
	@OneToMany(mappedBy = "candidat")
	private List<Inscription> inscriptions;

	
}
