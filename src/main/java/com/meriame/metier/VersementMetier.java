package com.meriame.metier;

import java.text.ParseException;

import com.meriame.dto.VersementDTO;
import com.meriame.exception.BankTransactionException;
import com.meriame.model.Compte;

public interface VersementMetier {
	
	public void addAmount(Compte compte,double amount) throws BankTransactionException;
	public void verse(VersementDTO V) throws BankTransactionException, ParseException;

}
