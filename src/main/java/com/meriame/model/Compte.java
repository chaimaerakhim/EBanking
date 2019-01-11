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
public class Compte implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCompte;
	private double solde;
	private String etat;
	@ManyToOne
	@JoinColumn(name="id_client")
	@JsonBackReference(value="comptesClient")
	private Client client;
	@OneToMany(mappedBy="cmptSource")
	@JsonManagedReference(value="versementsourCompte")
	private List<Versement> versementsour;
	@OneToMany(mappedBy = "cmptDestination")
    @JsonManagedReference(value="versementdestCompte")
	private List<Versement> versementdest;
	
	public Long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Long idCompte) {
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
	

	
	
	public List<Versement> getVersementsour() {
		return versementsour;
	}
	public void setVersementsour(List<Versement> versementsour) {
		this.versementsour = versementsour;
	}
	public List<Versement> getVersementdest() {
		return versementdest;
	}
	public void setVersementdest(List<Versement> versementdest) {
		this.versementdest = versementdest;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(long id,double solde, String etat, Client client) {
		super();
		this.idCompte=id;
		this.solde = solde;
		this.etat = etat;
		this.client = client;
	}
	public Compte(double solde, String etat, Client client) {
		super();
		this.solde = solde;
		this.etat = etat;
		this.client = client;
	}
	
	
	
	
}
