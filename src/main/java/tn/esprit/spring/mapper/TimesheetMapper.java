package tn.esprit.spring.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.dto.ContratDTO;
import tn.esprit.spring.dto.DepartementDTO;
import tn.esprit.spring.dto.EmployeDTO;
import tn.esprit.spring.dto.EntrepriseDTO;
import tn.esprit.spring.dto.MissionDTO;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;

@Component
public class TimesheetMapper {

	@Autowired
    private ConfiguredModelMapper modelMapper;

	public Employe mapEmployeDtoToEmploye(EmployeDTO employedto) {
		Employe mappedEmploye = modelMapper.map(employedto , Employe.class);
		mappedEmploye.setActif(employedto.isActif());
		mappedEmploye.setContrat(employedto.getContrat());
		mappedEmploye.setDepartements(employedto.getDepartements());
		mappedEmploye.setEmail(employedto.getEmail());
		mappedEmploye.setNom(employedto.getNom());
		mappedEmploye.setPassword(employedto.getPassword());
		mappedEmploye.setPrenom(employedto.getPrenom());
		mappedEmploye.setRole(employedto.getRole());
		mappedEmploye.setTimesheets(employedto.getTimesheets());
			return mappedEmploye;
	}
	
	public Contrat mapContratDtoToContrat(ContratDTO contratdto) {
		Contrat mappedContrat = modelMapper.map(contratdto, Contrat.class);
		mappedContrat.setDateDebut(contratdto.getDateDebut());
		mappedContrat.setEmploye(contratdto.getEmploye());
		mappedContrat.setSalaire(contratdto.getSalaire());
		mappedContrat.setTelephone(contratdto.getTelephone());
		mappedContrat.setTypeContrat(contratdto.getTypeContrat());
			return mappedContrat;
	}
	
	public Entreprise mapEntrepriseDtoToEntreprise(EntrepriseDTO entreprisedto) {
		Entreprise mappedEntreprise = modelMapper.map(entreprisedto, Entreprise.class);
		mappedEntreprise.setDepartements(entreprisedto.getDepartements());
		mappedEntreprise.setName(entreprisedto.getName());
		mappedEntreprise.setRaisonSocial(entreprisedto.getRaisonSocial());
			return mappedEntreprise;
	}
	
	public Departement mapDepartementDtoToDepartement(DepartementDTO departementdto) {
		Departement mappedDepartement = modelMapper.map(departementdto, Departement.class);
		mappedDepartement.setEmployes(departementdto.getEmployes());
		mappedDepartement.setEntreprise(departementdto.getEntreprise());
		mappedDepartement.setMissions(departementdto.getMissions());
		mappedDepartement.setName(departementdto.getName());
			return mappedDepartement;
	}
	
	public Mission mapMissionDtoToMission(MissionDTO missiondto) {
		Mission mappedMission = modelMapper.map(missiondto, Mission.class);
		mappedMission.setDepartement(missiondto.getDepartement());
		mappedMission.setDescription(missiondto.getDescription());
		mappedMission.setName(missiondto.getName());
		mappedMission.setTimesheets(missiondto.getTimesheets());
			return mappedMission;
	}
}
