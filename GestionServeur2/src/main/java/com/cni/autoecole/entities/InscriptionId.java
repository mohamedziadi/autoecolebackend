package com.cni.autoecole.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class InscriptionId implements Serializable{
	@Column(name = "cin_candidat")
	private String cinCandidat;
	@Column(name = "id_auto_ecole")
	private Long idAutoEcole;

}
