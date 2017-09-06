package com.mycom.myapplications.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mycom.myapplications.backend.model.Application;
import com.mycom.myapplications.backend.model.Component;
import com.mycom.myapplications.backend.model.Vendor;
import com.mycom.myapplications.backend.repositories.ApplicationRepository;
import com.mycom.myapplications.backend.repositories.ComponentRepository;
import com.mycom.myapplications.backend.repositories.VendorRepository;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private ComponentRepository componentRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Application> getAllApplications() {
		return (List<Application>) applicationRepository.findAll();
	}

	public Application createApplication(Application app) {
		Vendor vendor = new Vendor(app.getVendor().getId(), app.getVendor().getVendorName());

		if (!vendorRepository.exists(vendor.getId())) {
			vendor = vendorRepository.save(vendor);

		}
		app.setVendor(vendor);
		List<Component> modifiedComs = new ArrayList<>();

		for (Component com : app.getComponents()) {
			if (!componentRepository.exists(com.getId())) {
				Component saveCom = new Component(com.getId(), com.getComponentName());
				saveCom = componentRepository.save(saveCom);
				modifiedComs.add(saveCom);
			}
		}

		app.setComponents(modifiedComs);

		Application savedApp = applicationRepository.save(app);

		return savedApp;
	}

	public Application getApplicationById(long id) {
		return applicationRepository.findOne(id);
	}

	public Application updateApplication(long id, Application app) {
		
		app.setId(id);
		
		Vendor vendor = new Vendor(app.getVendor().getId(), app.getVendor().getVendorName());

		if (!vendorRepository.exists(vendor.getId())) {
			vendor = vendorRepository.save(vendor);

		}
		app.setVendor(vendor);
		List<Component> modifiedComs = new ArrayList<>();

		for (Component com : app.getComponents()) {
			if (!componentRepository.exists(com.getId())) {
				Component saveCom = new Component(com.getId(), com.getComponentName());
				saveCom = componentRepository.save(saveCom);
				modifiedComs.add(saveCom);
			}
			else
			{
				modifiedComs.add(com);
			}
		}

		app.setComponents(modifiedComs);

		Application savedApp = applicationRepository.save(app);

		return savedApp;
		
	}

	public void removeApplication(long id) {
		
		applicationRepository.delete(id);
		
	}
}
