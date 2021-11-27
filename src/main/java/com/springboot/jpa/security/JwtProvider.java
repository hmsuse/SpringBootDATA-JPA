package com.springboot.jpa.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.springboot.jpa.security.jwt.services.UserPrinciple;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
	public class JwtProvider {
		
		@Value("${grokonez.app.jwtScret}")
		private String jwtScret;
		
		@Value("${grokonez.app.jwtExpiration}")
		private int jwtExpiration;
		
		public String generateWebToken(Authentication auth) {
			
			UserPrinciple user=(UserPrinciple) auth.getPrincipal();
			
			if(user.getUsername().equals("root")) {
				return Jwts.builder().setSubject(user.getUsername())
						.setIssuedAt(new Date())
						.setExpiration(new Date((new Date()).getTime()+jwtExpiration*1000))
						.signWith(SignatureAlgorithm.HS512, jwtScret).compact();
			}else {
				return Jwts.builder().setSubject(user.getUsername())
						.setIssuedAt(new Date())
						.setExpiration(new Date((new Date()).getTime()+jwtExpiration*1000))
						.signWith(SignatureAlgorithm.HS512, jwtScret).compact();

			}
			
			
		}
		
		public boolean validateJwtToken(String auth) {
			
			try {
				Jwts.parser().setSigningKey(jwtScret).parseClaimsJws(auth);
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return false;
			
		}

		
		public String getUserNameFromJwt(String token){
			return Jwts.parser().setSigningKey(jwtScret).
					parseClaimsJws(token).getBody().getSubject();
		}

		public Date getExpireDate(String token) {
			return Jwts.parser().setSigningKey(jwtScret).
					parseClaimsJws(token).getBody().getExpiration();
		}
}
