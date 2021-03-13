package com.example.MoM.controller.formController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.crud.OrganizationMemberCrudDto;
import com.example.MoM.dto.formDto.registerDto.RegisterFormDto;
import com.example.MoM.dto.formDto.registerDto.RegisterSuccessDto;
import com.example.MoM.dto.formDto.registerDto.RegisteredMemberDto;
import com.example.MoM.dto.formDto.registerDto.RegisteredOrganizationDto;
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
	public RegisterSuccessDto regiserOrganization(@RequestBody RegisterFormDto registerForm) {
		
		OrganizationMemberCrudDto memberDto = mapper.map(registerForm, OrganizationMemberCrudDto.class);

		OrganizationEntity orgEntity = mapper.map(registerForm, OrganizationEntity.class);
		OrganizationMemberEntity memberEntity = mapper.map(registerForm, OrganizationMemberEntity.class);
		
		
//		if(!memberDto.getName().equals(memberEntity.getMemberName())) {
//			memberEntity.setMemberName(memberDto.getName());
//		}
//		if(!memberDto.getRole().equals(memberEntity.getOrganizationRole())) {
//			memberEntity.setOrganizationRole(memberDto.getRole());
//		}
		
		System.out.println(registerForm);
		System.out.println(memberDto);
		System.out.println(orgEntity);
		System.out.println(memberEntity);
		
		OrganizationEntity orgEntity2 = organizationRepository.save(orgEntity);
		RegisteredOrganizationDto registeredOrganizationDto = mapper.map(orgEntity2, RegisteredOrganizationDto.class);
		System.out.println(orgEntity2);
		System.out.println(registeredOrganizationDto);
		
		memberEntity.setOrganizationEntity(orgEntity2);
		
		OrganizationMemberEntity memberEntity2 = organizationMemberRepository.save(memberEntity);
		
		RegisteredMemberDto registeredMemberDto = mapper.map(memberEntity2, RegisteredMemberDto.class);
		
		RegisterSuccessDto registerSuccessDto = new RegisterSuccessDto();
		registerSuccessDto.setMember(registeredMemberDto);
		registerSuccessDto.setOrganization(registeredOrganizationDto);
		return registerSuccessDto;
		
		
//		orgEntity.setOrganizationMembers(new ArrayList<OrganizationMemberEntity>());
//		orgEntity.getOrganizationMembers().add(memberEntity);
//		
		
//		
//		orgEntity2 = organizationRepository.findById(orgEntity2.getOrganizationId()).orElse(orgEntity2);
//		
//		
//		OrganizationCrudDto orgDto2 = mapper.map(orgEntity2, OrganizationCrudDto.class);
//		return orgDto2;
		
//		return null;
	}

}