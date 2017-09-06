package com.mycom.myapplications.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String vendorName;
	
	public Vendor()
	{		
	}
	
	public Vendor(long id, String vendorName) {	
		this.id = id;
		this.vendorName = vendorName;
	}
	
	public Vendor(String vendorName) {
		this.vendorName = vendorName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	
	

}
