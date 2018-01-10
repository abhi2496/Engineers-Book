package com.gtu.EngBook.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value="/user")
public class FirstController {
	
	
/*	@RequestMapping(value="/login")
	public String login(@RequestBody Map<String, Object> req)
	{	
		String login = req.get("login").toString();
		String pass = req.get("pass").toString();
		
		
		return login;
	}*/
	
	
	

	/*
	 * @RequestMapping(value="/login")
	public JSONObject login(@RequestBody Map<String, Object> req)
	{	
		String login = req.get("login").toString();
		String pass = req.get("pass").toString();
		
		Map<String, Object> res = new HashMap<>();
		JSONObject myJson= new JSONObject();
		try {
		 
		myJson.put("login", login);
		myJson.put("pass", pass);
		} catch (Exception e) {
			
		}
		
		return myJson;
	}*/
}