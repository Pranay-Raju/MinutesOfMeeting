package com.example.MoM.controller.formController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.formDto.LoggedInMemberDto;
import com.example.MoM.dto.formDto.LoginCredentials;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.repositories.OrganizationMemberRepository;

/**
 * Controller to 
 * 
 * @author Pranay Raju
 *
 */
@RestController
public class LoginController {

	@Autowired
	OrganizationMemberRepository memberRepository;

	@Autowired
	ModelMapper mapper;

	@PostMapping("/userWithCredentials")
	public LoggedInMemberDto fetchUserWithCredentials(@RequestBody LoginCredentials credentials) {
		
		OrganizationMemberEntity memberEntity = memberRepository
				.findByLoginIdAndPassword(credentials.getLoginId(), credentials.getPassword())
				.orElse(new OrganizationMemberEntity());
		
		System.out.println("Org Data is " + memberEntity.getOrganizationEntity());
		LoggedInMemberDto loggedInMemberDto = mapper.map(memberEntity, LoggedInMemberDto.class);
		System.out.println("Logged In Member is " + loggedInMemberDto);
		
//		OrganizationMemberCrudDto dto = mapper.map(memberEntity, OrganizationMemberCrudDto.class);
		return loggedInMemberDto;
	}

}
