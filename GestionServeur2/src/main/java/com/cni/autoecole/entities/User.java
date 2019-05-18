package com.cni.autoecole.entities;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // La stratégie Single Table crée une table pour chaque hiérarchie
														// de classes.
@DiscriminatorColumn(name = "role")
public class User implements Serializable, UserDetails {

	@Id
	private String cin;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String username;
	private String password;
	private boolean connected;

	@JsonIgnore
	@Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		if (this instanceof Admin) {
			authorities.add(new SimpleGrantedAuthority("ROLE_Admin"));
		} else if (this instanceof Secretaire) {
			authorities.add(new SimpleGrantedAuthority("ROLE_Secretaire"));
		} else if (this instanceof Candidat) {
			authorities.add(new SimpleGrantedAuthority("ROLE_Candidat"));
		} else if (this instanceof Moniteur) {

			if (((Moniteur) this).isGerant()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_Gerant"));
			} else {
				authorities.add(new SimpleGrantedAuthority("ROLE_Moniteur"));
			}
		}
		return authorities;
	}

	@JsonIgnore
	@Transient
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Transient
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Transient
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
