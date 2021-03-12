package com.example.MoM.controller.formController;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.patterns.DeclareTypeErrorOrWarning;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.crud.OrganizationMemberCrudDto;
import com.example.MoM.dto.formDto.MeetingDto;
import com.example.MoM.entity.OrganizationEntity;
import com.example.MoM.entity.OrganizationMeetingEntity;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.repositories.OrganizationMeetingRepository;
import com.example.MoM.repositories.OrganizationMemberRepository;

@RestController
public class MeetingFormController {
	
	@Autowired
	private OrganizationMemberRepository memberRepository;
	
	@Autowired
	private OrganizationMeetingRepository meetingRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@PostMapping("/meetingForm/save")
	public OrganizationMeetingEntity save(@RequestBody MeetingDto meetingDto ) {
		
		OrganizationMeetingEntity meetingEntity = mapper.map(meetingDto, OrganizationMeetingEntity.class);
		meetingEntity.setId(0);
		
		OrganizationMemberEntity memberEntity = mapper.map(meetingDto, OrganizationMemberEntity.class);
		meetingEntity.setFacilitator(memberEntity);
		
		OrganizationEntity organizationEntity = mapper.map(meetingDto, OrganizationEntity.class);
		meetingEntity.setOrganizationEntity(organizationEntity);
		
		System.out.println(meetingEntity);
		
//		return meetingRepository.save(meetingEntity);
		return null;
		
	}
	
	@GetMapping("/allFacilitators/{id}")
	public List<OrganizationMemberCrudDto> allFacilitators(@PathVariable("id") int id){
		List<OrganizationMemberEntity> list = memberRepository.findAllByOrganizationIdAndRole(id,"facilitator");
		List<OrganizationMemberCrudDto> dtos = new ArrayList<OrganizationMemberCrudDto>();
		for(OrganizationMemberEntity entity: list) {
			dtos.add(mapper.map(entity, OrganizationMemberCrudDto.class));
		}
		return dtos;
	}
	

}
