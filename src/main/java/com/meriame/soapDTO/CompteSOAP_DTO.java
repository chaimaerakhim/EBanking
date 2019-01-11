package com.meriame.soapDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="CompteSOAP_DTO")
public class CompteSOAP_DTO {
	
	private long idCompte;
	private double solde;
	private String etat;
	public long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(long idCompte) {
		this.idCompte = idCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public CompteSOAP_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompteSOAP_DTO(double solde, String etat) {
		super();
		this.solde = solde;
		this.etat = etat;
	}
	public CompteSOAP_DTO(long idCompte, double solde, String etat) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.etat = etat;
	}
	
	

}
