package com.meriame.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.meriame.dao.AgenceRepository;
import com.meriame.model.Agence;


@Service
public class AgenceMetierImpl implements AgenceMetier {
	
	@Autowired
	private AgenceRepository agenceRepository;

	@Override
	public Agence findAgenceById_agence(Long id_agence) {
		// TODO Auto-generated method stub
		return agenceRepository.findAgenceById(id_agence);
	}

	@Override
	public Agence saveAgence(Agence admin) {
		// TODO Auto-generated method stub
		return agenceRepository.save(admin);
	}

	@Override
	public void deleteAgenceById_agence(Long id_agence) {
		Agence agence=findAgenceById_agence(id_agence);
		agenceRepository.delete(agence);
		
	}
	
	

}
