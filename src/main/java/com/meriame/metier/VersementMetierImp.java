package com.meriame.metier;

import com.meriame.model.Compte;
import com.meriame.model.Versement;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.meriame.dao.CompteRepository;
import com.meriame.dao.VersementRepository;
import com.meriame.dto.VersementDTO;
import com.meriame.exception.BankTransactionException;

@Service

public class VersementMetierImp implements VersementMetier {
	
	public static final String datePattern = "dd/MM/yyyy HH:mm:ss";
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private VersementRepository versementRepository;

	@Override
	@Transactional(propagation = Propagation.MANDATORY )
	public void addAmount(Compte compte, double amount) throws BankTransactionException {
		
		if(compte==null) {
			 throw new BankTransactionException("Account not found " + compte.getIdCompte());
		}
		double newSolde = compte.getSolde() + amount;
        if (compte.getSolde() + amount < 0) {
            throw new BankTransactionException(
                    "The money in the account '" + compte.getIdCompte() + "' is not enough (" + compte.getSolde() + ")");
        }
        compte.setSolde(newSolde);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = BankTransactionException.class)
	public void verse(VersementDTO V) throws BankTransactionException, ParseException {
		Compte compteSource = compteRepository.findByIdCompte(V.getCmptSource());
		Compte compteDestination = compteRepository.findByIdCompte(V.getCmptDestination());
		try {
			addAmount(compteSource,-V.getMontant());
			addAmount(compteDestination,V.getMontant());
			DateFormat df = new SimpleDateFormat(datePattern);
			Versement v = new Versement(compteSource, compteDestination,df.parse(df.format(Calendar.getInstance().getTime())),V.getMontant());
			versementRepository.save(v);
		} catch (BankTransactionException e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	/*@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = BankTransactionException.class)
	public void verse(VersementDTO V) throws BankTransactionException, ParseException {
		
		Compte compteSource = compteRepository.findByIdCompte(V.getCmptSource());
		Compte compteDestination = compteRepository.findByIdCompte(V.getCmptDestination());
		try {
			addAmount(compteSource,-V.getMontant());
			addAmount(compteDestination,V.getMontant());
			DateFormat df = new SimpleDateFormat(datePattern);
			Versement v = new Versement(compteSource, compteDestination,df.parse(df.format(Calendar.getInstance().getTime())),V.getMontant());
			versementRepository.save(v);
		} catch (BankTransactionException e) {
			// TODO: handle exception
			throw e;
		}
		
		
		
	}
	*/

}
