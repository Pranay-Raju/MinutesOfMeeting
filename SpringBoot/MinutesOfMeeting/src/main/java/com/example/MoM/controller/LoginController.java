package com.example.MoM.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.LoginCredentials;
import com.example.MoM.dto.OrganizationMemberDto;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.repositories.OrganizationMemberRepository;

@RestController
public class LoginController {

	@Autowired
	OrganizationMemberRepository memberRepository;

	@Autowired
	ModelMapper mapper;

	@PostMapping("/userWithCredentials")
	public OrganizationMemberDto fetchUserWithCredentials(@RequestBody LoginCredentials credentials) {
		OrganizationMemberEntity entity = memberRepository
				.findByLoginIdAndPassword(credentials.getLoginId(), credentials.getPassword())
				.orElse(new OrganizationMemberEntity());
		OrganizationMemberDto dto = mapper.map(entity, OrganizationMemberDto.class);
		System.out.println(credentials);
		return dto;
	}

}
