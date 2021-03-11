package com.example.MoM.controller.crud;

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

import com.example.MoM.dto.crud.OrganizationMemberCrudDto;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.repositories.OrganizationMemberRepository;

@RestController
@RequestMapping("/member")
public class OrganizationMemberController {

	@Autowired
	private OrganizationMemberRepository organizationMemberRepository;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/all")
	public List<OrganizationMemberCrudDto> getAll() {
		List<OrganizationMemberEntity> list = organizationMemberRepository.findAll();
		List<OrganizationMemberCrudDto> dtos = new ArrayList<OrganizationMemberCrudDto>();
		for (OrganizationMemberEntity entity : list) {
			dtos.add(mapper.map(entity, OrganizationMemberCrudDto.class));
		}

		return dtos;
//		return organizationMemberRepository.findAll();
	}

	@PostMapping("/save")
	public OrganizationMemberCrudDto save(@RequestBody OrganizationMemberEntity organizationMember) {
		OrganizationMemberEntity entity = organizationMemberRepository.save(organizationMember);
		return mapper.map(entity, OrganizationMemberCrudDto.class);
	}

	@GetMapping("/byId/{id}")
	public OrganizationMemberCrudDto getById(@PathVariable("id") int id) {
		OrganizationMemberEntity entity = organizationMemberRepository.findById(id)
				.orElse(new OrganizationMemberEntity());
		return mapper.map(entity, OrganizationMemberCrudDto.class);
	}

	@DeleteMapping("/")
	public void delete(@RequestBody OrganizationMemberEntity organizationMember) {
		organizationMemberRepository.delete(organizationMember);
	}

	@GetMapping("/byOrgId/{id}")
	public List<OrganizationMemberCrudDto> save2(@PathVariable("id") int id) {
		List<OrganizationMemberEntity> memberEntities = organizationMemberRepository.findAllByOrganizationId(id);
		List<OrganizationMemberCrudDto> orgDtos = new ArrayList<OrganizationMemberCrudDto>();
		for (OrganizationMemberEntity entity : memberEntities) {
			orgDtos.add(mapper.map(entity, OrganizationMemberCrudDto.class));
		}
		return orgDtos;
	}

}
