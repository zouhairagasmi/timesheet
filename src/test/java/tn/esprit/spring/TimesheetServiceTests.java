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




@Test 
public void TestvaliderTimesheet() {
	
	Date dd = parseDate("2020-11-02");
	Date df = parseDate("2020-11-04");
	service.validerTimesheet(1,1,dd,df,0);
	TimesheetPK p =new TimesheetPK(1, 1, dd, df);
	assertNull(rep.findBytimesheetPK(p));
	//Timesheet pp= new Timesheet(true);
	
	//assertNull(rep.findById(a.getId()));
}


/*

@Test 
public void TestfindAllMissionByEmployeJPQL() {
	Employe e = employerepository.findById(1).get();
	List<Mission> m =service.findAllMissionByEmployeJPQL(e.getId());
	assertNotNull(m);
}*/


/////////////////TEST/////////////////////
/*@Test
public void TestgetAllEmployeByMission(){
	Mission m =missrep.findById(1).get();
List<Employe> e =service.getAllEmployeByMission(m.getId());
assertNotNull(m);
}*/
	















/*	@Test 
	public void TestajouterMission() {
		Mission a = new Mission("hello","youu");
		int id =service.ajouterMission(a);
		assertEquals(3,id);
	}
*/

	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	}}
	/*@Test
	public void TestajouterTimesheet() {
		Date dd = parseDate("3020-01-05");
		Date df = parseDate("2028-02-01");
	TimesheetPK o =new TimesheetPK(2, 1, dd, df);
	 service.ajouterTimesheet(2, 1, dd, df);
		 assertNull(rep.findBytimesheetPK(o));
	}*/

/*@Test 
public void TestaffecterMissionADepartement() {
service.affecterMissionADepartement(1,1);
 Mission m =missrep.findById(1).get();
 int iddep =m.getDepartement().getId();

assertEquals(1,iddep);

}*/