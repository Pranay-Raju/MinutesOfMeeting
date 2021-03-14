package com.example.MoM.controller.formController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.formDto.minutesDto.HeadingFormDto;

@RestController
public class MinutesController {
	
	@PostMapping("/saveheading")
	public void saveHeading(@RequestBody HeadingFormDto dto ) {
		
	}

}
