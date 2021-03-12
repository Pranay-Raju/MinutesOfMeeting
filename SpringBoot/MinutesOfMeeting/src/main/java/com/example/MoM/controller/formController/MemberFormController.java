package com.example.MoM.controller.formController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.crud.OrganizationMemberCrudDto;
import com.example.MoM.dto.formDto.MemberFormDto;
import com.example.MoM.entity.OrganizationEntity;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.repositories.OrganizationMemberRepository;
import com.example.MoM.repositories.OrganizationRepository;

@RestController
public class MemberFormController {

	@Autowired
	ModelMapper mapper;
	@Autowired
	private OrganizationMemberRepository repository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@PostMapping("memberForm/save")
	public OrganizationMemberCrudDto save(@RequestBody MemberFormDto memberFormDto) {

		OrganizationMemberEntity memberEntity = mapper.map(memberFormDto, OrganizationMemberEntity.class);
		OrganizationEntity organizationEntity = mapper.map(memberFormDto.getOrganization(), OrganizationEntity.class);

		memberEntity.setOrganizationMemberId(0);

		organizationEntity = organizationRepository.getOne(organizationEntity.getOrganizationId());
		memberEntity.setOrganizationEntity(organizationEntity);
		OrganizationMemberEntity memberEntity2 = repository.save(memberEntity);

		OrganizationMemberCrudDto memberCrudDto = mapper.map(memberEntity2, OrganizationMemberCrudDto.class);
		return memberCrudDto;

	}
	
	@PostMapping("memberForm/update")
	public OrganizationMemberCrudDto update(@RequestBody MemberFormDto memberFormDto) {

		OrganizationMemberEntity memberEntity = mapper.map(memberFormDto, OrganizationMemberEntity.class);
		OrganizationEntity organizationEntity = mapper.map(memberFormDto.getOrganization(), OrganizationEntity.class);

		memberEntity.setOrganizationMemberId(memberFormDto.getMemberId());

		organizationEntity = organizationRepository.getOne(organizationEntity.getOrganizationId());
		memberEntity.setOrganizationEntity(organizationEntity);
		OrganizationMemberEntity memberEntity2 = repository.save(memberEntity);

		OrganizationMemberCrudDto memberCrudDto = mapper.map(memberEntity2, OrganizationMemberCrudDto.class);
		return memberCrudDto;

	}

	@GetMapping("deleteMember/{id}")
	public String delete(@PathVariable("id") int id) {
		repository.deleteById(id);
		return "success";

	}

}
