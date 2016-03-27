package com.exp.dynamicroles.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

	
	@Autowired
	private SessionRegistry sessionRegistry;
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/denied")
	public String denied(){
		return "denied";
	}
	
	@RequestMapping(value="/userPage")
	public String userPage(){
		return "user";
	}
	
	@RequestMapping(value="/adminPage")
	public String adminPage(ModelMap model){
		List principals = sessionRegistry.getAllPrincipals();
		List<String> sessionCollection = new ArrayList<String>();
		
		for(Object principal : principals) {
			Iterator<SessionInformation> sessionInfoList = sessionRegistry.getAllSessions(principal, false).iterator();
			
			while(sessionInfoList.hasNext()) {
				SessionInformation sessionInfo = sessionInfoList.next();
				System.out.println("sessionId>>" + sessionInfo.getSessionId());
				sessionCollection.add(sessionInfo.getSessionId());
			}
			
			
		}
		
		model.addAttribute("sessionList",sessionCollection);
		System.out.println();
		
		return "sessions";
	}
	
	@RequestMapping(value="/dashboard")
	public String dashboard(HttpServletRequest request,Model model){
		model.addAttribute("roles", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		model.addAttribute("useragent", request.getHeader("user-agent"));
		model.addAttribute("sessionId", request.getSession(false).getId());
		System.out.println(request.getHeader("user-agent") + " sessionId::" + request.getSession(false).getId());
		
		
		return "dashboard";
	}
	@RequestMapping(value="/disconnect-{sessionId}-user", method=RequestMethod.GET)
	public String disconnect(@PathVariable String sessionId) {
		SessionInformation sessionInfo = sessionRegistry.getSessionInformation(sessionId);
		if(null != sessionInfo) {
			sessionInfo.expireNow();
		}
		return "redirect:/adminPage";
	}
	
}
