package com.meriame.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Compte")
public class Compte implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCompte;
	private double solde;
	private String etat;
	@ManyToOne
	@JoinColumn(name="id_client")
	@JsonBackReference(value="clientCompte")
	private Client client;
	@OneToMany(mappedBy="cmptSource")
	@JsonManagedReference(value="compteVersementSour")
	private List<Versement> versementsour;
	@OneToMany(mappedBy = "cmptDestination")
    @JsonManagedReference(value="compteVersementDest")
	private List<Versement> versementdest;
	
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Versement> getVersementSour() {
		return versementsour;
	}
	public void setVersementSour(List<Versement> versementsour) {
		this.versementsour = versementsour;
	}
	
	public List<Versement> getVersementDest() {
		return versementdest;
	}
	public void setVersementDest(List<Versement> versementdest) {
		this.versementdest = versementdest;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(int id,double solde, String etat, Client client) {
		super();
		this.idCompte=id;
		this.solde = solde;
		this.etat = etat;
		this.client = client;
	}
	
	
	
	
}
