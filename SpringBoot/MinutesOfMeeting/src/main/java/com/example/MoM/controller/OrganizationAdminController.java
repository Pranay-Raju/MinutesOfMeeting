package com.example.MoM.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.OrganizationMemberDto;
import com.example.MoM.dto.orgAdmin.OrgDto;
import com.example.MoM.entity.OrganizationEntity;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.repositories.OrganizationMemberRepository;
import com.example.MoM.repositories.OrganizationRepository;

@RestController
public class OrganizationAdminController {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private OrganizationMemberRepository organizationMemberRepository;

	@Autowired
	ModelMapper mapper;

	@GetMapping("/allOrganizations")
	public List<OrgDto> getAll() {
		List<OrganizationEntity> orglist = organizationRepository.findAll();
		List<OrgDto> orgDtos = new ArrayList<OrgDto>();
		for(OrganizationEntity entity:orglist) {
			orgDtos.add(mapper.map(entity, OrgDto.class));
		}
		return orgDtos;
	}
	
	@GetMapping("/getByOrg/{orgId}")
	public List<OrganizationMemberDto> getAll(@PathVariable("orgId")int id) {
		List<OrganizationMemberEntity> orgMemberList = organizationMemberRepository.findAllByOrganizationId(id);
		List<OrganizationMemberDto> orgDtos = new ArrayList<OrganizationMemberDto>();
		for(OrganizationMemberEntity entity:orgMemberList) {
			orgDtos.add(mapper.map(entity, OrganizationMemberDto.class));
		}
		
		return orgDtos;
	}
}
