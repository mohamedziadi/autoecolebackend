package com.cni.autoecole.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Seance implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	private Date date;
	private String etat;
	private String place;
	private String prix;
	private String nbHoraire;


	@Temporal(TemporalType.TIMESTAMP)
	private Date CreatedAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	@ManyToOne
	private Inscription inscription;
}

