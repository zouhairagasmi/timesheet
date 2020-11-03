package tn.esprit.spring;
import static org.junit.Assert.assertNotNull;





import static org.junit.Assert.assertNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService; 


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImpl2Test {
	
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired 
	IEmployeService iemployeservice; 
	@Autowired 
	IDepartementService idepartementservice; 
	
	@Autowired
	EmployeRepository employerepository;
	@Autowired
	MissionRepository missionrepository;
	
	@Autowired
	ContratRepository contratrepository;
	
	@Autowired
	EntrepriseRepository entrepriserepository;

//	@Test
//	public void testaddOrUpdateEmploye() {
//	int x = iemployeservice.getNombreEmployeJPQL() ;
//	Employe e = new Employe("oussema", "baccara", "oussema@gmail.com", "123456", true, Role.ADMINISTRATEUR);
//	iemployeservice.addOrUpdateEmploye(e);		
//	assertEquals(x+1, iemployeservice.getNombreEmployeJPQL());
//	}
//	
//@Test
//	public void mettreAjourEmailByEmployeId() {
//		String y ="oussema2222@gmail.com";
//		iemployeservice.mettreAjourEmailByEmployeId(y, 10);
//		Employe employe =employerepository.findById(10).get();
//		String w = employe.getEmail();
//		assertEquals(y,w);
//
//	}
	@Test
	public void affecterEmployeADepartement() {
		iemployeservice.affecterEmployeADepartement(11, 1);
		Employe e= employerepository.findById(10).get();
		int idd =e.getDepartements().get(0).getId();
		assertEquals(1, idd);
		
	}
	}

	


	


