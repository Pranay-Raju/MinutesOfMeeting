package com.example.MoM.controller.formController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.crud.OrganizationMemberCrudDto;
import com.example.MoM.dto.formDto.LoginCredentials;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.repositories.OrganizationMemberRepository;

@RestController
public class LoginController {

	@Autowired
	OrganizationMemberRepository memberRepository;

	@Autowired
	ModelMapper mapper;

	@PostMapping("/userWithCredentials")
	public OrganizationMemberCrudDto fetchUserWithCredentials(@RequestBody LoginCredentials credentials) {
		
		OrganizationMemberEntity memberEntity = memberRepository
				.findByLoginIdAndPassword(credentials.getLoginId(), credentials.getPassword())
				.orElse(new OrganizationMemberEntity());
		
		System.out.println(memberEntity.getOrganizationEntity());
		
		OrganizationMemberCrudDto dto = mapper.map(memberEntity, OrganizationMemberCrudDto.class);
		return dto;
	}

}
