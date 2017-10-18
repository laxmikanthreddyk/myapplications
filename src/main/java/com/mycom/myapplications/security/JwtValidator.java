package com.mycom.myapplications.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String secret = "SecretKey";

	public JwtUser Validate(String token) {
		// TODO Auto-generated method stub
		JwtUser jwtuser = null;

		try {

			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			jwtuser = new JwtUser();

			jwtuser.setUserName(body.getSubject());
			jwtuser.setId(Long.parseLong((String) body.get("userId")));
			jwtuser.setRole((String) body.get("role"));

		} catch (Exception e) {
			System.out.println(e);
		}
		return jwtuser;
	}

}
