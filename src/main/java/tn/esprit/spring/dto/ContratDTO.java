package tn.esprit.spring.dto;

import java.util.Date;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.esprit.spring.entities.Employe;



public class ContratDTO{
	
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	private String typeContrat;
	
	private float telephone;
	
	@OneToOne
	private Employe employe;

	private float salaire;

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public float getTelephone() {
		return telephone;
	}

	public void setTelephone(float telephone) {
		this.telephone = telephone;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}


	
	
}