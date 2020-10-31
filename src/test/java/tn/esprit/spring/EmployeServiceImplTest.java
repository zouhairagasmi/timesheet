
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
public class EmployeServiceImplTest {
	
	
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
	public void testauthenticate() {
	
	 	Employe e1 = new Employe("zohrag", "Gasmi", "zohra@gmail.com","123456", true, Role.INGENIEUR);
		iemployeservice.addOrUpdateEmploye(e1);
		Employe e = iemployeservice.authenticate("zohra@gmail.com", "123456");
		System.out.println("authenticated successfully");
		if (e == null)	
		System.out.println("error");
		assertEquals("zohrag", e.getNom());
}*/
	
	
	/*@Test
	public void testdeleteContratById() {
	
				Contrat c = new Contrat(1, "cdi", 2);
				iemployeservice.ajouterContrat(c);
				iemployeservice.deleteContratById(c.getReference());
				assertNull(employerepository.findById(c.getReference()));
}

*/
	
	@Test
	public void getNombreEmployeJPQL() {
		
				//Employe e1 = new Employe("zohra", "gasmi", "zohra@gmail.com", true, Role.INGENIEUR);
				//Employe e2 = new Employe("oussema", "baccara", "oussema@gmail.com", true, Role.ADMINISTRATEUR);
				//iemployeservice.addOrUpdateEmploye(e1);
				//iemployeservice.addOrUpdateEmploye(e2);
				int nbr = iemployeservice.getNombreEmployeJPQL() ;
				assertEquals(6, nbr);
}
	
	
	
	/*@Test
	public void getAllEmployeNamesJPQL() {
		
				List<String> L = iemployeservice.getAllEmployeNamesJPQL();
				String name = L.get(0);
				assertEquals("zohra", name);
			}
	*/
	
	/*@Test
	public void getAllEmployes() {
		
				List<Employe> L = iemployeservice.getAllEmployes();
				
				assertEquals(6, L.size());
			}*/
		
	
	/*
	@Test
	public void getAllEmployeByEntreprise() {
		
				Entreprise E = entrepriserepository.findById(1).get();
				List<Employe> L = iemployeservice.getAllEmployeByEntreprise(E);
				String name = L.get(0).getNom();
				assertEquals("zohra", name);
			}
	*/
	/*
	@Test
	public void mettreAjourEmailByEmployeIdJPQL() {
		
				
				int id = employerepository.findById(1).get().getId();
				iemployeservice.mettreAjourEmailByEmployeIdJPQL("zohra.zohra@gmail.com", id);
				assertEquals("zohra.zohra@gmail.com", employerepository.findById(1).get().getEmail());
			}
	*/
	
	
	 public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	  
	/*
	 @Test
		public void deleteAllContratJPQL() {
			
		iemployeservice.deleteAllContratJPQL() ;
		assertNull(contratrepository.findAll() );
				
	 }
	
	*/
	 /*
	 @Test
		public void getSalaireByEmployeIdJPQL() {
			
		
		assertEquals(1000, iemployeservice.getSalaireByEmployeIdJPQL(employerepository.findById(1).get().getId()));
				
	 }
	 */
	/* 
	 @Test
		public void getTimesheetsByMissionAndDate() {
		 
		Employe e = employerepository.findById(1).get();
		Mission m = missionrepository.findById(1).get();
		Date dateDebut = parseDate("2020-01-01");
		Date dateFin = parseDate("2021-01-01");
		 
		
	    List<Timesheet> t = iemployeservice.getTimesheetsByMissionAndDate(e, m, dateDebut, dateFin) ;
	    assertNotNull(t);
				
	 }
	*/

}

