package tn.esprit.spring.dto;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;


public class EmployeDTO{
	

	
	
	private String prenom;
	
	private String nom;
	
	private String email;

	private String password;
	
	private boolean actif;
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	private Role role;
	
	//@JsonBackReference  
	@JsonIgnore
	@ManyToMany(mappedBy="employes",fetch=FetchType.EAGER )
	//@NotNull
	private List<Departement> departements;
	
	@JsonIgnore
	//@JsonBackReference
	@OneToOne(mappedBy="employe")
	private Contrat contrat;
	
	@JsonIgnore
	//@JsonBackReference
	@OneToMany(mappedBy="employe")
	private List<Timesheet> timesheets;

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	
	
	
}