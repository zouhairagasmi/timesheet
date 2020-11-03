package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService {

	private static final Logger l = Logger.getLogger(TimesheetServiceImpl.class);
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	public int ajouterMission(Mission mission) {
		missionRepository.save(mission);
		l.info("mission ajouté" +mission);
		return mission.getId();
	}
    
	public void affecterMissionADepartement(int missionId, int depId) {
		Optional<Mission> mission = missionRepository.findById(missionId);
		if(mission.isPresent()) {
			l.info("Mission affectéeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		Optional<Departement>dept =deptRepoistory.findById(depId);
		l.info("check itttttttttttttttttttttttttttttttt");
		if(dept.isPresent())
		{
			l.info("Departement affectéeeeeeeeeeeeeeeeeeeeeeeeeeee");
			mission.get().setDepartement(dept.get());		
			l.info("saveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			
		missionRepository.save(mission.get());
		
		l.info("c boneeeeeeeeeeeeeeeeeeeeeeee");
		}}
		
	}

	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
		timesheetPK.setIdEmploye(employeId);
		timesheetPK.setIdMission(missionId);
		
		Timesheet timesheet = new Timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false); //par defaut non valide
		timesheetRepository.save(timesheet);
		l.info("timesheet ajouté" );
		
	}

	
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		l.info("In valider Timesheettttttttttttttttttttttttttttttttttttttttt");
		
		Optional<Employe> validateur=employeRepository.findById(validateurId);
		if (validateur.isPresent()) {
			 Employe EmpValidator =validateur.get() ;
				if (!validateur.isPresent()) {
					l.info("passsssssssssssssssssssss d'emplyé");}
		
		Optional<Mission> mission=missionRepository.findById(missionId);
		if (mission.isPresent()) {
		//verifier s'il est un chef de departement (interet des enum)
		if(!EmpValidator.getRole().equals(Role.CHEF_DEPARTEMENT)){
			l.info("l'employe doit etre chef de departement pour valider une feuille de tempsssssssssssssssssssssssssssssss !");
			return;
		} 
		//verifier s'il est le chef de departement de la mission en question
		boolean chefDeLaMission = false;
		for(Departement dep : EmpValidator.getDepartements()){
			if(dep.getId() == mission.get().getDepartement().getId()){
				chefDeLaMission = true;
				break;
			}
		}
		if(!chefDeLaMission){
			l.info("l'employe doit etre chef de departement de la mission en question");
			return;
		}}}
		TimesheetPK timesheetPK = new TimesheetPK(missionId, employeId, dateDebut, dateFin);
		Timesheet timesheet =timesheetRepository.findBytimesheetPK(timesheetPK);
		timesheet.setValide(true);
		
		//Comment Lire une date de la base de données
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		l.info("dateDebutttttttttttttttttttttttttttttttttttttttttt : " + dateFormat.format(timesheet.getTimesheetPK().getDateDebut()));
		
	}
	
	public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
		
		l.info("oooooooooooooooooooo");
		return timesheetRepository.findAllMissionByEmployeJPQL(employeId);
		
	}

	
	public List<Employe> getAllEmployeByMission(int missionId) {
		l.info("finding employeessssssssssssssssss.");
		return timesheetRepository.getAllEmployeByMission(missionId);
	}

}
