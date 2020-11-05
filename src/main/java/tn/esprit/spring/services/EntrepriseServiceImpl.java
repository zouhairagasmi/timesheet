package tn.esprit.spring.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);
	
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		l.info("Entreprise ajoutée...");
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		l.info("Departement ajouté..");
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		
	Optional<Departement> value = deptRepoistory.findById(depId);
	Optional<Entreprise> valuee = entrepriseRepoistory.findById(entrepriseId);
		if (value.isPresent()) {
			Departement depManagedEntity = value.get();
		
		if (valuee.isPresent()) {
				Entreprise entrepriseManagedEntity = valuee.get();
				

				
		depManagedEntity.setEntreprise(entrepriseManagedEntity);
		l.info("Departement affecté avec succes..");
	   deptRepoistory.save(depManagedEntity);
		
	}
		}
	}
	
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<String> depNames = new ArrayList<>();
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);
		if (value.isPresent()) {
			Entreprise entrepriseManagedEntity = value.get();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
			l.info("Deprtement name list.." + depNames.toString());	
		}
		
		return depNames;
	
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);
		if (value.isPresent()) {
			Entreprise entrepriseManagedEntity = value.get();
		    entrepriseRepoistory.delete(entrepriseManagedEntity);
		    l.info("Entreprise supprimé avec succes.."+ entrepriseManagedEntity.getId());
	}
		else 
		{
			l.info("Entreprise non trouvée..");
			
		}
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		Optional<Departement> value = deptRepoistory.findById(depId);
		if (value.isPresent()) {
			Departement departementManagedEntity = value.get();
			deptRepoistory.delete(departementManagedEntity);
		    l.info("departement supprimé avec succes.."+departementManagedEntity.getId());
		
	}
		else 
		{
			l.info("departement non trouvée..");
			
		}
	}

	public Entreprise getEntrepriseById(int entrepriseId) {
		l.info("Getting Entreprise by Id...");
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);		
		if (value.isPresent()) {
			
		Entreprise entrepriseManagedEntity = value.get();	
		return entrepriseManagedEntity;
	}
	return null;

	}
	
}