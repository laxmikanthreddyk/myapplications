package com.mycom.myapplications.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapplications.security.JwtGenerator;
import com.mycom.myapplications.security.JwtUser;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private JwtGenerator jwtGenerator;

	@PostMapping
	public String generateToken(@RequestBody final JwtUser jwtUser)
	{
		
		String token =  jwtGenerator.generate(jwtUser);
		
	    return token;		
	}
}
