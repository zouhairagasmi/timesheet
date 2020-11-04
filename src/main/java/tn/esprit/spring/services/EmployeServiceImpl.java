package tn.esprit.spring.services;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	private static final Logger l = Logger.getLogger(EmployeServiceImpl.class);

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;

	@Override
	public Employe authenticate(String login, String password) {
		l.info("authenticatation is loading...");
		return employeRepository.findEmployeByEmailAndPassword(login, password);
	}

	/******************************** Oussema In **************************/

	@Override
	public int addOrUpdateEmploye(Employe employe) {
		l.info("add or update Employe:" + employe);
		employeRepository.save(employe);
		return employe.getId();
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		try {
		l.info("mettre a jour un employe ");
		Optional<Employe> value = employeRepository.findById(employeId);

		if (value.isPresent()) {
			Employe employe = value.get();
			employe.setEmail(email);
			employeRepository.save(employe);
		}
		}
		catch (Exception e) { l.error("Erreur dans mettreAjourEmailByEmployeId() : " + e); }

	}

	@Transactional	
	public void affecterEmployeADepartement(int employeId, int depId) {
		try {
		l.info("affecterEmployeADepartement loading...");
		Optional<Departement> value = deptRepoistory.findById(depId);
		Optional<Employe> value1 = employeRepository.findById(employeId);
		if(value.isPresent() && value1.isPresent() ) {
			Departement depManagedEntity =value.get();
			Employe employeManagedEntity =value1.get();
			if(depManagedEntity.getEmployes() == null){

				List<Employe> employes = new ArrayList<>();
				employes.add(employeManagedEntity);
				depManagedEntity.setEmployes(employes);
			}else{

				depManagedEntity.getEmployes().add(employeManagedEntity);
			}

			// à ajouter? 
			deptRepoistory.save(depManagedEntity); 
			
		}}
		catch (Exception e) { l.error("Erreur dans affecterEmployeADepartement() : " + e); }

	}

	@Transactional
	public void desaffecterEmployeDuDepartement(int employeId, int depId) {
		l.info("desaffecterEmployeDuDepartement loading...");
		try {
		Optional<Departement> value = deptRepoistory.findById(depId);
		if(value.isPresent()) {
			Departement dep=value.get();
			int employeNb = dep.getEmployes().size();
			for (int index = 0; index < employeNb; index++) {
				if (dep.getEmployes().get(index).getId() == employeId) {
					dep.getEmployes().remove(index);
					break;// a revoir
				}
			}	
		}}
		catch (Exception e) { l.error("Erreur dans desaffecterEmployeDuDepartement() : " + e); }
	}

	// Tablesapce (espace disque)

	public int ajouterContrat(Contrat contrat) {
		l.info("add Contrat loading...");

		contratRepoistory.save(contrat);
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		l.info("affecterContratAEmploye loading...");
		try {
		Optional<Contrat> value = contratRepoistory.findById(contratId);
		Optional<Employe> value1 = employeRepository.findById(employeId);
		if(value.isPresent() && value1.isPresent() ) {
			Contrat contratManagedEntity =value.get();
			Employe employeManagedEntity =value1.get();	
			contratManagedEntity.setEmploye(employeManagedEntity);
			contratRepoistory.save(contratManagedEntity);
		}}
		catch (Exception e) { l.error("Erreur dans affecterContratAEmploye() : " + e); }

	}

	public String getEmployePrenomById(int employeId) {
		l.info("getEmployePrenomById loading...");
		
		Optional<Employe> value = employeRepository.findById(employeId);
		Employe employeManagedEntity = new Employe();
		if (value.isPresent()) {
			employeManagedEntity = value.get();
			

		}
		return employeManagedEntity.getPrenom();
	}

	public void deleteEmployeById(int employeId) {
		l.info("deleteEmployeById loading...");
		Optional<Employe> value = employeRepository.findById(employeId);
		if(value.isPresent()) {
			Employe employe =value.get();	
		for (Departement dep : employe.getDepartements()) {
			dep.getEmployes().remove(employe);
		}

		employeRepository.delete(employe);
		}
	}

	/******************************** Oussema Out **************************/

	/******************************** Zohra In *******************************/

	public void deleteContratById(int contratId) {
		l.info("Exécution de la méthode delete contrat");
		l.debug("Suppression d'un contrat");
		Optional<Contrat> value = contratRepoistory.findById(contratId);

		if (value.isPresent()) {
			Contrat contratManagedEntity = value.get();
			contratRepoistory.delete(contratManagedEntity);
			l.debug("Fin de Suppression d'un contrat");
			l.info("Fin de l'exécution de la méthode delete contrat avec id ="+ contratId);
			

		}
	}

	public int getNombreEmployeJPQL() {
		l.info("Exécution de la méthode getNombreEmployeJPQL");
		l.debug("Retourner le nombre des employees : ");
		l.info("il y a " + employeRepository.countemp() + " employes");
		return employeRepository.countemp();
	}

	public List<String> getAllEmployeNamesJPQL() {
		l.info("Exécution de la méthode getAllEmployeNamesJPQL");
		l.debug("Retourner les noms des employees : ");
		return employeRepository.employeNames();

	}

	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		l.info("Exécution de la méthode getAllEmployeByEntreprise");
		l.debug("Retourner la liste des employees d'une entreprise : ");
		return employeRepository.getAllEmployeByEntreprisec(entreprise);
	}

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		l.info("Exécution de la méthode mettreAjourEmailByEmployeIdJPQL");
		l.debug("mise a jour de l'email ");
		l.info("le nouveau email de l'employee : "+employeId+"est: "+email);
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);

	}

	public void deleteAllContratJPQL() {
		l.info("Exécution de la méthode delete tous contrats");
		l.debug("Suppression des contrats");
		employeRepository.deleteAllContratJPQL();
	}

	public float getSalaireByEmployeIdJPQL(int employeId) {
		l.info("Exécution de la méthode getSalaireByEmployeIdJPQL");
		l.debug("Retourner la salaire d'un employee : ");
		l.info("la salaire de l'employee : "+employeId+"est: ");
		return employeRepository.getSalaireByEmployeIdJPQL(employeId);
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		l.info("Exécution de la méthode getSalaireMoyenByDepartementId");
		l.debug("Retourner la salaise moyenne de departement : ");
		return employeRepository.getSalaireMoyenByDepartementId(departementId);
	}

	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		l.info("Exécution de la méthode getTimesheetsByMissionAndDate");
		l.debug("Retourner la timesheet : ");
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	public List<Employe> getAllEmployes() {
		l.info("Exécution de la méthode getAllEmployeByEntreprise");
		l.debug("Retourner la liste des employees d'une entreprise : ");
		l.info("Employe List: " + employeRepository.findAll());
		return (List<Employe>) employeRepository.findAll();

	}

	/******************************** Zohra Out *******************************/

}