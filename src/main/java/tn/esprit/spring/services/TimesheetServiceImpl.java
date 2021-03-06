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
	//DONE
	public int ajouterMission(Mission mission) {
		missionRepository.save(mission);
		l.info("mission ajoutée avec succès :" +mission);
		return mission.getId();
	}
    
	public void affecterMissionADepartement(int missionId, int depId) {
		Optional<Mission> mission = missionRepository.findById(missionId);
		if(mission.isPresent()) {
			l.info("Mission affectée");
		Optional<Departement>dept =deptRepoistory.findById(depId);
		l.info("check it");
		if(dept.isPresent())
		{
			l.info("Departement affectée");
			mission.get().setDepartement(dept.get());		
			l.info("save");
			
		missionRepository.save(mission.get());
		
		l.info("c bon");
		}}
		
	}
//DONE
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
//HDONE
	
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		l.info("In valider Timesheet");
		Optional<Employe> oppEmploye= employeRepository.findById(validateurId);
		if(oppEmploye.isPresent()) {
			Employe validateur = oppEmploye.get();
			l.info("role validateur = "+validateur.getRole());
			//verifier s'il est un chef de departement (interet des enum)
			if(!validateur.getRole().equals(Role.CHEF_DEPARTEMENT)){
				l.info("l'employe doit etre chef de departement pour valider une feuille de temps !");
				return;
			}
			//verifier s'il est le chef de departement de la mission en question
			boolean chefDeLaMission = false;
			Optional<Mission> oppMission= missionRepository.findById(missionId);
			if (oppMission.isPresent()){
				Mission mission = oppMission.get();
				for(Departement dep : validateur.getDepartements()){
				if(dep.getId() == mission.getDepartement().getId()){
					chefDeLaMission = true;
					l.info("pour departementttttttttttttttttttttttttttttttttttttttttttttttttttttt:"+dep+"chef de la mission = "+chefDeLaMission);
					break;
				}
				}
			}
			if(!chefDeLaMission){
				l.info("l'employe doit etre chef de departement de la mission en questionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
				return;
			
		}}
		
		TimesheetPK timesheetPK = new TimesheetPK(missionId, employeId, dateDebut, dateFin);
		Timesheet timesheet =timesheetRepository.findBytimesheetPK(timesheetPK);
		l.info("timesheet= "+timesheet);
		timesheet.setValide(true);
		timesheetRepository.save(timesheet);
		l.info("timesheet= "+timesheet);		
		//Comment Lire une date de la base de données
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		l.info("dateDebut : " + dateFormat.format(timesheet.getTimesheetPK().getDateDebut()));
	}
	///HDONE
	public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
		
		l.info("les misssions dont leurs employeId=" +employeId);
		return timesheetRepository.findAllMissionByEmployeJPQL(employeId);
		
	}

	////DONE
	public List<Employe> getAllEmployeByMission(int missionId) {
		l.info("Employees whose their mission id="+missionId +timesheetRepository.getAllEmployeByMission(missionId) );
		return timesheetRepository.getAllEmployeByMission(missionId);
	}

}
