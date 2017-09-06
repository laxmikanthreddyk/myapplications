package com.mycom.myapplications.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapplications.backend.model.Application;
import com.mycom.myapplications.services.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Application>> getAllApplications() {
		return new ResponseEntity<List<Application>>(applicationService.getAllApplications(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Application> getApplicationById(@PathVariable long id) {
		Application app = applicationService.getApplicationById(id);

		if (null != app) {
			return new ResponseEntity<Application>(app, HttpStatus.FOUND);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Application> createApplication(@RequestBody Application app) {
		Application newapp = applicationService.createApplication(app);

		if (null != newapp) {
			return new ResponseEntity<Application>(newapp, HttpStatus.CREATED);
		}

		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Application> updateApplication(@PathVariable long id, @RequestBody Application app) {
		Application newapp = applicationService.updateApplication(id, app);

		if (null != newapp) {
			return new ResponseEntity<Application>(newapp, HttpStatus.CREATED);
		}

		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity removeApplication(@PathVariable long id) {
		applicationService.removeApplication(id);

		return new ResponseEntity(HttpStatus.OK);
	}
}
