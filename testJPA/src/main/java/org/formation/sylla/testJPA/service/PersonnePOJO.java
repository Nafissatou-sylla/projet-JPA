package org.formation.sylla.testJPA.service;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the personne database table.
 * 
 */
@Entity
@Table(name="personne")
@NamedQuery(name="PersonnePOJO.findAll", query="SELECT p FROM PersonnePOJO p")
public class PersonnePOJO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nom;

	private String prenom;

	private String telephone;

	public PersonnePOJO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}