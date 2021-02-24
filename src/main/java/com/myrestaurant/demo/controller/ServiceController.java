package com.myrestaurant.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	@RequestMapping("/getapi")
	public String getApi() {
		return "Hellow from API";
	}
	
	
	
	
	
	
}
