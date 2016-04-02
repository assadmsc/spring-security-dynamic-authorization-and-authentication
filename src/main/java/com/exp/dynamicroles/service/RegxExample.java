package com.exp.dynamicroles.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		extractValueFromUrl();
	}
	
	//     url=/edit-ll-employee get 
	public static void extractValueFromUrl() {
		String mydata = "/edit-ll0000-employee";
		Pattern pattern = Pattern.compile("-(.*?)-");
		Matcher matcher = pattern.matcher(mydata);
		
		
		if (matcher.find())
		{
		    System.out.println(matcher.group(0));
		    System.out.println(mydata.replace(matcher.group(0), "-{*}-"));
		}		
	}

}
