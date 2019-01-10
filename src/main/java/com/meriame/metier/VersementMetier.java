package com.meriame.metier;

import java.text.ParseException;

import com.meriame.exception.BankTransactionException;
import com.meriame.model.Compte;
import com.meriame.model.Versement;

public interface VersementMetier {
	
	public void addAmount(Compte compte,double amount) throws BankTransactionException;
	public void verse(Versement V) throws BankTransactionException, ParseException;

}
