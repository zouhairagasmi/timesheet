package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
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

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.ITimesheetService;
import java.util.Date;

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
	public void TestajouterMission() {
		Mission a = new Mission("hello2","youu2");
		int id =service.ajouterMission(a);
		assertEquals(2,id);
	}
}
