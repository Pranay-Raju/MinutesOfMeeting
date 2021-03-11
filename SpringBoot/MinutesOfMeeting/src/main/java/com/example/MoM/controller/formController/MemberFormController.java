package com.example.MoM.controller.formController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.formDto.MemberFormDto;

@RestController
public class MemberFormController {
	
	@PostMapping("memberForm/save")
	public void save(@RequestBody MemberFormDto memberFormDto) {
		System.out.println("IN MEMBER FORM SAVE METHOD");
		System.out.println(memberFormDto);
		
	}

}
