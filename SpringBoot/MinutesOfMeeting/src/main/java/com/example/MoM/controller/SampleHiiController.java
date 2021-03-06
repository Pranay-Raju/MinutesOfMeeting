package com.example.MoM.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.formDto.LoginCredentials;

@RestController
public class SampleHiiController {
	
	@RequestMapping("/hii")
	public String showHi() {
		return "Hi!! welcome";
		
	}
    @PostMapping("/hello1")
	public  LoginCredentials Hello(@RequestBody LoginCredentials dto) {
    	System.out.println(dto);
		return dto;
	}
	
	

}
