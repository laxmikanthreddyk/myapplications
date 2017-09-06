package com.mycom.myapplications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mycom.myapplications.backend.model.Application;
import com.mycom.myapplications.backend.model.Component;
import com.mycom.myapplications.backend.model.Vendor;
import com.mycom.myapplications.services.ApplicationService;

@SpringBootApplication
public class MyapplicationsApplication implements CommandLineRunner  {

	@Autowired
	private ApplicationService applicationService;
	
	public static void main(String[] args) {
		SpringApplication.run(MyapplicationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Vendor vendor = new Vendor("Cognizant");
		
		List<Component> components = new ArrayList<Component>(){
			{
			add(new Component("AIV"));
			add(new Component("IRC"));
			add(new Component("AIVWeb"));
			}
			
		};		
		
		Application app = new Application("Online HIP","Highered Catalog Application",vendor, components);
		
		Application savedApp = applicationService.createApplication(app);
		
	}
	
	
}
