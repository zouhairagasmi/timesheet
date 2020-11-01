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
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.IEmployeService; 


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImpl2Test {
	
	
	@Autowired 
	IEmployeService iemployeservice; 
	
	@Autowired
	EmployeRepository employerepository;
	@Autowired
	MissionRepository missionrepository;
	
	@Autowired
	ContratRepository contratrepository;
	
	@Autowired
	EntrepriseRepository entrepriserepository;

	/*@Test
	public void testaddOrUpdateEmploye() {
	int x = iemployeservice.getNombreEmployeJPQL() ;
	Employe e = new Employe("oussema", "baccara", "oussema@gmail.com", "123456", true, Role.ADMINISTRATEUR);
	iemployeservice.addOrUpdateEmploye(e);		
	assertEquals(x+1, iemployeservice.getNombreEmployeJPQL());
	}
	//ok ok
*/
}
