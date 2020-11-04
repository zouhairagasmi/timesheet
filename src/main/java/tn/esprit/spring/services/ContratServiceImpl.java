package tn.esprit.spring.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {
	private static final Logger l = Logger.getLogger(ContratServiceImpl.class);

	@Autowired
	ContratRepository contratRepository;

//teste
	public List<Contrat> getAllContrats() {
		return (List<Contrat>) contratRepository.findAll();
	}
	
	public int getNombreContratJPQL() {
		l.info("getNombreContratJPQL loading...");
		l.info("il y a " + contratRepository.countemp() + " contrats");
		return contratRepository.countemp();
	}

}
