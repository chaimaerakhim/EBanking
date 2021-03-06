package com.meriame.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.meriame.model.Compte;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Versement")
public class VersementDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JsonBackReference(value="compteVersementSour")
	private Long cmptSource;
	@ManyToOne
    @JsonBackReference(value="compteVersementDest")
	private Long cmptDestination;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTransaction;
	
	private double montant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Long getCmptSource() {
		return cmptSource;
	}

	public void setCmptSource(Long cmptSource) {
		this.cmptSource = cmptSource;
	}

	public Long getCmptDestination() {
		return cmptDestination;
	}

	public void setCmptDestination(Long cmptDestination) {
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
	
	
}
