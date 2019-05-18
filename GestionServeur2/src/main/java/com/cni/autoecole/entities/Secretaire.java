package com.cni.autoecole.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data; //geters et setters

@Entity
@Data // geters et setters
public class Secretaire extends User implements Serializable {
	@ManyToOne
	private AutoEcole autoEcole;
}
