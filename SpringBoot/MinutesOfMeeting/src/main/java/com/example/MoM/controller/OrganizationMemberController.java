package com.example.MoM.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.OrganizationMemberDto;
import com.example.MoM.dto.OrganizationMemberDto;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.repositories.OrganizationMemberRepository;
import com.example.MoM.repositories.OrganizationRepository;

@RestController
@RequestMapping("/member")
public class OrganizationMemberController {

	@Autowired
	private OrganizationMemberRepository organizationMemberRepository;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/all")
	public List<OrganizationMemberDto> getAll() {
		List<OrganizationMemberEntity> list = organizationMemberRepository.findAll();
		List<OrganizationMemberDto> dtos = new ArrayList<OrganizationMemberDto>();
		for (OrganizationMemberEntity entity : list) {
			dtos.add(mapper.map(entity, OrganizationMemberDto.class));
		}

		return dtos;
//		return organizationMemberRepository.findAll();
	}

	@PostMapping("/save")
	public OrganizationMemberDto save(@RequestBody OrganizationMemberEntity organizationMember) {
		OrganizationMemberEntity entity = organizationMemberRepository.save(organizationMember);
		return mapper.map(entity, OrganizationMemberDto.class);
	}

	@GetMapping("/byId/{id}")
	public OrganizationMemberDto save(@PathVariable("id") int id) {
		OrganizationMemberEntity entity = organizationMemberRepository.findById(id).orElse(new OrganizationMemberEntity());
		return mapper.map(entity, OrganizationMemberDto.class);
	}

	@DeleteMapping("/")
	public void delete(@RequestBody OrganizationMemberEntity organizationMember) {
		organizationMemberRepository.delete(organizationMember);
	}

}
