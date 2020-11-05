package tn.esprit.spring;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.ITimesheetService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceTests {

@Autowired
ITimesheetService service;
@Autowired
TimesheetRepository rep;
@Autowired 
EmployeRepository employerepository;
@Autowired
MissionRepository missrep;
@Autowired
DepartementRepository deprep;



/*
@Test 
public void TestvaliderTimesheet() {
	//(1,3,dd,df,3) et (1, 3, dd, df)le validateur qui est un ingenieur doit etre chef de departement pour valider une feuille de temps 
	//(1,3,dd,df,2)et (1, 3, dd, df)le validateur qui est chef de departement mais l'employe doit etre chef de departement de la mission en question
	Date dd = parseDate("2020-11-02");
	Date df = parseDate("2020-11-04");
	service.validerTimesheet(1,1,dd,df,2);
	TimesheetPK p =new TimesheetPK(1, 2, dd, df);
	assertNotNull(rep.findBytimesheetPK(p));

	
}*/
/*
@Test 
public void TestfindAllMissionByEmployeJPQL() {
	Employe e = employerepository.findById(1).get();
	List<Mission> m =service.findAllMissionByEmployeJPQL(e.getId());
	assertNotNull(m);
}
*/

/////////////////TEST/////////////////////
//Voir table Timesheet 
//mission =1 -->employe=3:amir
//mission =2 -->employe=3:hssan
/*@Test
public void TestgetAllEmployeByMission(){
	Mission m =missrep.findById(2).get();
List<Employe> e =service.getAllEmployeByMission(m.getId());
assertNotNull(m);
}*/
	










/*




	@Test 
	public void TestajouterMission() {
		Mission a = new Mission("la vita ","youu");
		int id =service.ajouterMission(a);
		assertEquals(3,id);
	}


	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	}
	@Test
	public void TestajouterTimesheet() {
		Date dd = parseDate("7000-01-05");
		Date df = parseDate("8000-02-01");
	TimesheetPK o =new TimesheetPK(1, 3, dd, df);
	 service.ajouterTimesheet(1, 3, dd, df);
		 assertNotNull(rep.findBytimesheetPK(o));
	}}

/*@Test 
public void TestaffecterMissionADepartement() {
service.affecterMissionADepartement(1,1);
 Mission m =missrep.findById(1).get();
 int iddep =m.getDepartement().getId();

assertEquals(1,iddep);

}*/
}