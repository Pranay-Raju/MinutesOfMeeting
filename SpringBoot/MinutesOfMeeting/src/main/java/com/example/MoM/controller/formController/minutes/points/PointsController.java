package com.example.MoM.controller.formController.minutes.points;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.formDto.minutesDto.pointDto.PointDto;
import com.example.MoM.entity.MomHeadingEntity;
import com.example.MoM.entity.MomPointEntity;
import com.example.MoM.entity.OrganizationMeetingEntity;
import com.example.MoM.repositories.MomHeadingRepository;
import com.example.MoM.repositories.MomPointRepository;
import com.example.MoM.repositories.OrganizationMeetingRepository;

@RestController
@RequestMapping("/pointForm")
public class PointsController {
	
	@Autowired
	MomHeadingRepository headingRepository;
	
	@Autowired
	OrganizationMeetingRepository meetingRepository;
	
	@Autowired
	MomPointRepository pointRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@PostMapping("/save")
	public PointDto save(@RequestBody PointDto dto) {
		System.out.println(dto);
		MomHeadingEntity headingEntity = headingRepository.getOne(dto.getHeading().getId());
//		OrganizationMeetingEntity meetingEntity = meetingRepository.getOne(dto.getMeeting().getId());
		
		MomPointEntity pointEntity = mapper.map(dto, MomPointEntity.class); 
		pointEntity.setHeading(headingEntity);
		pointEntity.setInfo(dto.getValue());
		
		MomPointEntity pointEntity2 = pointRepository.save(pointEntity);
		PointDto pointdto = mapper.map(pointEntity2, PointDto.class);
		pointdto.setValue(pointEntity2.getInfo());
		return pointdto;
	}
	

}
