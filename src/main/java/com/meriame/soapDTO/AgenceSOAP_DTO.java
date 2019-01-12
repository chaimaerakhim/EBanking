package com.meriame.soapDTO;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="AgenceSOAP_DTO")
public class AgenceSOAP_DTO {
	
	
	private Long id;
	private String adresse;
	private Date datedouverture;
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDatedouverture() {
		return datedouverture;
	}
	public void setDatedouverture(Date datedouverture) {
		this.datedouverture = datedouverture;
	}
	
	public AgenceSOAP_DTO(Long id_agence,String adresse,Date datedouverture) {
		
		super();
		this.id=id_agence;
		this.adresse=adresse;
		this.datedouverture=datedouverture;
		
		
	}
	public AgenceSOAP_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
