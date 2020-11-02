package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImpTest {
	@Autowired
	IEntrepriseService ientrepriseservice;
	
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	@Test
	public void testAddEntrperise() {
		
			Entreprise a = new Entreprise (4,"monentreprise","fiscal");
			ientrepriseservice.ajouterEntreprise(a);
			
			assert (entrepriseRepoistory.findById(a.getId())) != null;
}
	@Test
	public void  testajouterDepartement() {
		Departement d=new Departement (4,"dep administration");
		ientrepriseservice.ajouterDepartement(d);
		assert ( deptRepoistory.findById(d.getId())) != null;
		
	}
}
