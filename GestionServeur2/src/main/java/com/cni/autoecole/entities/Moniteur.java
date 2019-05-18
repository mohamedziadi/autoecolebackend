package com.cni.autoecole.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Moniteur extends User implements Serializable {
	@ManyToOne
	private AutoEcole autoEcole;
    private boolean gerant;
}
