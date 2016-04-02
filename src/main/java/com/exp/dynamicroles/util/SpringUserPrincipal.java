package com.exp.dynamicroles.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.exp.dynamicroles.model.LoggedUser;

public class SpringUserPrincipal {
	public static Object getUserPrincipal() {
		SecurityContext sc = SecurityContextHolder.getContext();
		
		
		if(null != sc) {
			Authentication aut = sc.getAuthentication();
			
			
			if(null != aut && aut.getPrincipal() instanceof User) {
				System.out.println("user" + ((User)aut.getPrincipal()).getUsername());
				
//				return (User) aut.getPrincipal();
			}
			
			
			if(null != aut && aut.getPrincipal() instanceof LoggedUser) {
				System.out.println("This is logged user informnation" + aut.getPrincipal());
			}
			
			
			
			//SecurityContextHolder.getContext().setAuthentication(null)
			//SecurityContextHolder.clearContext()
			
	
		}
		
		return null;
	}
}
