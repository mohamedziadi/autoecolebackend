package com.cni.autoecole.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Inscription implements Serializable {
	@EmbeddedId
	private InscriptionId id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private boolean confirmed;
	@ManyToOne
	@JoinColumn(name = "cin_candidat", insertable = false, updatable = false)
	private Candidat candidat;

	@ManyToOne
	@JoinColumn(name = "id_auto_ecole", insertable = false, updatable = false)
	private AutoEcole autoEcole;
	@JsonIgnore
	@OneToMany(mappedBy = "inscription")
	private List<Examen> examens;
	
	@JsonIgnore
	@OneToMany(mappedBy = "inscription")
	private List<Seance> seances;
}
