package com.example.MoM.controller.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.OrganizationDto;
import com.example.MoM.dto.orgAdmin.OrgDto;
import com.example.MoM.entity.OrganizationEntity;
import com.example.MoM.repositories.OrganizationRepository;

@RestController
@RequestMapping("/org")
public class OrganizationController {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/all")
	public List<OrganizationDto> getAll() {
		List<OrganizationEntity> list = organizationRepository.findAll();
		List<OrganizationDto> dtos = new ArrayList<OrganizationDto>();
		for (OrganizationEntity entity : list) {
			dtos.add(mapper.map(entity, OrganizationDto.class));
		}

		return dtos;
	}
	
	@GetMapping("/byName/{name}")
	public OrgDto getOrganizationByName(@PathVariable("name") String orgName) {
		System.out.println("NAME IS " + orgName);
		OrganizationEntity orgEntity = organizationRepository.findByOrganizationName(orgName).orElse(new OrganizationEntity());
		
		System.out.println("ENTITY IS" + orgEntity);
		OrgDto orgDto = mapper.map(orgEntity, OrgDto.class);
		System.out.println(orgDto);
		return orgDto;
	}

	@PostMapping("/save")
	public OrganizationDto save(@RequestBody OrganizationEntity organization) {
		OrganizationEntity entity = organizationRepository.save(organization);
		return mapper.map(entity, OrganizationDto.class);
	}

	@GetMapping("/byId/{id}")
	public OrganizationDto save(@PathVariable("id") int id) {
		OrganizationEntity entity = organizationRepository.findById(id).orElse(new OrganizationEntity());
		OrganizationDto orgDto = mapper.map(entity, OrganizationDto.class);
		return orgDto;
	}

	@DeleteMapping("/")
	public void delete(@RequestBody OrganizationEntity organization) {
		organizationRepository.delete(organization);
	}
	
}
