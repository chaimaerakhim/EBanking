package com.meriame.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meriame.dao.CompteRepository;
import com.meriame.model.Compte;

@Service
public class CompteMetierImpl implements CompteMetier{

	@Autowired
	private CompteRepository compteRepository;
	
	@Override
	public List<Compte> getComptesByClientId(Long id) {
		return compteRepository.findByClientId(id);
	}

	@Override
	public Compte saveCompte(Compte compte) {
		
		return compteRepository.save(compte);
	}

	@Override
	public Compte getCompteById(Long id) {
		// TODO Auto-generated method stub
		return compteRepository.findByIdCompte(id);
	}

	@Override
	public void deleteCompte(Compte compte) {
		
		compteRepository.delete(compte);
	}

}
