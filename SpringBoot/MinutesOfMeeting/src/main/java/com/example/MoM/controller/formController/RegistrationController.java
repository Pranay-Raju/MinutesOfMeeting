package com.example.MoM.controller.formController;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.OrganizationDto;
import com.example.MoM.dto.OrganizationMemberDto;
import com.example.MoM.dto.formDto.RegisterFormDto;
import com.example.MoM.entity.OrganizationEntity;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.repositories.OrganizationMemberRepository;
import com.example.MoM.repositories.OrganizationRepository;

@RestController
public class RegistrationController {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	OrganizationMemberRepository organizationMemberRepository;

	@PostMapping("/register")
	public OrganizationDto regiser(@RequestBody RegisterFormDto registerForm) {
		
		OrganizationDto orgDto = mapper.map(registerForm, OrganizationDto.class);
		OrganizationMemberDto memberDto = mapper.map(registerForm, OrganizationMemberDto.class);

		OrganizationEntity orgEntity = mapper.map(registerForm, OrganizationEntity.class);
		OrganizationMemberEntity memberEntity = mapper.map(registerForm, OrganizationMemberEntity.class);
		
		if(!memberDto.getName().equals(memberEntity.getMemberName())) {
			memberEntity.setMemberName(memberDto.getName());
		}
		if(!memberDto.getRole().equals(memberEntity.getOrganizationRole())) {
			memberEntity.setOrganizationRole(memberDto.getRole());
		}
		
		memberEntity.setOrganizationEntity(orgEntity);
		orgEntity.setOrganizationMembers(new ArrayList<OrganizationMemberEntity>());
		orgEntity.getOrganizationMembers().add(memberEntity);
		
		OrganizationEntity orgEntity2 = organizationRepository.save(orgEntity);
		OrganizationMemberEntity memberEntity2 = organizationMemberRepository.save(memberEntity);
		
		orgEntity2 = organizationRepository.findById(orgEntity2.getOrganizationId()).orElse(orgEntity2);
		
		
		OrganizationDto orgDto2 = mapper.map(orgEntity2, OrganizationDto.class);
		return orgDto2;
	}

}