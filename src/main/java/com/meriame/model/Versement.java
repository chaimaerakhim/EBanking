package com.meriame.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Versement")
@Entity
public class Versement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Compte cmptSource;
	@ManyToOne
	private Compte cmptDestination;
	private Date dateTransaction;
	
	private double montant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Compte getCmptSource() {
		return cmptSource;
	}

	public void setCmptSource(Compte cmptSource) {
		this.cmptSource = cmptSource;
	}

	public Compte getCmptDestination() {
		return cmptDestination;
	}

	public void setCmptDestination(Compte cmptDestination) {
		this.cmptDestination = cmptDestination;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Versement(Compte cmptSource, Compte cmptDestination, Date dateTransaction, double montant) {
		super();
		this.cmptSource = cmptSource;
		this.cmptDestination = cmptDestination;
		this.dateTransaction = dateTransaction;
		this.montant = montant;
	}

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
