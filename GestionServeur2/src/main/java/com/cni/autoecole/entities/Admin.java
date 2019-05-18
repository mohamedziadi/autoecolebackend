package com.cni.autoecole.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data; //geters et setters

@Entity
@Data // geters et setters
public class Admin extends User implements Serializable {

}
