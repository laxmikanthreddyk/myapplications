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
public class Component {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String componentName;
	
	public Component()
	{		
	}
	
	public Component(long id, String componentName) {	
		this.id = id;
		this.componentName = componentName;
	}
	
	public Component(String componentName) {	
		this.componentName = componentName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	
	

}
