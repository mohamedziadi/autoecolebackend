package com.cni.autoecole.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Seance implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	
	private String place;
	private String prix;
	private String nbHoraire;
	private int nbSeanceAtteint;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreatedAt;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
/*    @OneToOne
	private Planification planification;*/
    @ManyToOne()
	private  Inscription inscription;


}

