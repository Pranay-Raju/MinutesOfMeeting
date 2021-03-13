package com.example.MoM.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleHiiController {
	
	@RequestMapping("/hii")
	public String showHi() {
		return "Hi!! welcome";
		
	}
	
	

}
