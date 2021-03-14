package com.example.MoM.controller.formController.minutes.heading;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.formDto.minutesDto.headingDto.HeadingDto;
import com.example.MoM.entity.MomHeadingEntity;
import com.example.MoM.entity.OrganizationMeetingEntity;
import com.example.MoM.repositories.MomHeadingRepository;
import com.example.MoM.repositories.OrganizationMeetingRepository;

@RestController
@RequestMapping("/Heading")
public class HeadingController {
	
	@Autowired
	OrganizationMeetingRepository meetingRepository;
	
	@Autowired
	MomHeadingRepository headingRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@PostMapping("/save")
	public HeadingDto save(@RequestBody HeadingDto dto) {
		System.out.println(dto);
		
		OrganizationMeetingEntity meetingEntity = meetingRepository.findById(dto.getMeeting().getId()).orElse(new OrganizationMeetingEntity());
		MomHeadingEntity headingEntity = mapper.map(dto, MomHeadingEntity.class);
		headingEntity.setMeeting(meetingEntity);
		
		System.out.println(meetingEntity);
		System.out.println(headingEntity);
		
		MomHeadingEntity headingEntity2 = headingRepository.save(headingEntity);
		HeadingDto headingDto = mapper.map(headingEntity2, HeadingDto.class);
		
		return headingDto;
	}
	
	@PostMapping("/sub/save")
	public HeadingDto saveSub(@RequestBody HeadingDto dto) {
		System.out.println(dto);
		
		OrganizationMeetingEntity meetingEntity = meetingRepository.findById(dto.getMeeting().getId()).orElse(new OrganizationMeetingEntity());
		
		MomHeadingEntity headingEntity = mapper.map(dto, MomHeadingEntity.class);
		headingEntity.setMeeting(meetingEntity);
		
		MomHeadingEntity parentHeadingEntity = headingRepository.findById(dto.getParent().getId()).orElse(new MomHeadingEntity());
//		headingEntity.setMeeting(meetingEntity);
		
		headingEntity.setParentHeading(parentHeadingEntity);
		
		System.out.println(meetingEntity);
		System.out.println(headingEntity);
		System.out.println(parentHeadingEntity);
		
		MomHeadingEntity headingEntity2 = headingRepository.save(headingEntity);
		HeadingDto headingDto = mapper.map(headingEntity2, HeadingDto.class);
		
		return headingDto;
	}

}
