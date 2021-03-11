package com.example.MoM.controller;

import java.util.ArrayList;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoM.dto.crud.MomHeadingCrudDTO;
import com.example.MoM.dto.crud.OrganizationCrudDto;
import com.example.MoM.dto.crud.OrganizationMeetingCrudDto;
import com.example.MoM.dto.crud.OrganizationMemberCrudDto;
import com.example.MoM.entity.MomHeadingEntity;
import com.example.MoM.entity.MomPointEntity;
import com.example.MoM.entity.OrganizationEntity;
import com.example.MoM.entity.OrganizationMeetingEntity;
import com.example.MoM.entity.OrganizationMemberEntity;
import com.example.MoM.repositories.MomHeadingRepository;
import com.example.MoM.repositories.MomPointRepository;
import com.example.MoM.repositories.OrganizationMeetingRepository;
import com.example.MoM.repositories.OrganizationMemberRepository;
import com.example.MoM.repositories.OrganizationRepository;

@RestController
public class Sample {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private OrganizationMeetingRepository organizationMeetingRepository;

	@Autowired
	private OrganizationMemberRepository organizationMemberRepository;

	@Autowired
	private MomHeadingRepository headingRepository;

	@Autowired
	private MomPointRepository momPointRepository;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/hello")
	public /*OrganizationEntity*/ OrganizationCrudDto  hello() {

		// creating an Organization
		OrganizationEntity organization = new OrganizationEntity();
		organization.setOrganizationName("Talent Sprint");
		organization.setOrganizationAddress("Hyd");
		organization.setOrganizationDomain("talentsprint.com");
		organization.setOrganizationMobileNo("9989225602");

		// creating members in Organization
		OrganizationMemberEntity memberEntity1 = new OrganizationMemberEntity();
		memberEntity1.setMemberName("Harsha");
		memberEntity1.setAddress("SEC");
		memberEntity1.setGender("M");
		memberEntity1.setLoginId("harsha123");
		memberEntity1.setPassword("pass");
		memberEntity1.setOrganizationMailId("harsha@talentsprint.com");
		memberEntity1.setOrganizationMobileNo("9989225602");
		memberEntity1.setOrganizationRole("Trainer");
		memberEntity1.setOrganizationEntity(organization);
		memberEntity1.setAttendedMeetings(new ArrayList<OrganizationMeetingEntity>());
		memberEntity1.setFacilitatedMeetings(new ArrayList<OrganizationMeetingEntity>());

		OrganizationMemberEntity memberEntity2 = new OrganizationMemberEntity();
		memberEntity2.setMemberName("Pasha");
		memberEntity2.setAddress("DEL");
		memberEntity2.setGender("M");
		memberEntity2.setLoginId("pasha123");
		memberEntity2.setPassword("password");
		memberEntity2.setOrganizationMailId("pasha@talentsprint.com");
		memberEntity2.setOrganizationMobileNo("9989225602");
		memberEntity2.setOrganizationRole("Manager");
		memberEntity2.setOrganizationEntity(organization);
		memberEntity2.setAttendedMeetings(new ArrayList<OrganizationMeetingEntity>());
		memberEntity2.setFacilitatedMeetings(new ArrayList<OrganizationMeetingEntity>());

		// Creating a meeting in Organization
		OrganizationMeetingEntity meeting = new OrganizationMeetingEntity();
		meeting.setMeetingName("Project Meeting");
		meeting.setStartDateAndTime(new Date());
		meeting.setEndDateAndTime(new Date());
		meeting.setOrganizationEntity(organization);
		meeting.setAttendees(new ArrayList<OrganizationMemberEntity>());

		// adding attendees
		meeting.getAttendees().add(memberEntity1);
		meeting.getAttendees().add(memberEntity2);

		memberEntity1.getAttendedMeetings().add(meeting);
		memberEntity2.getAttendedMeetings().add(meeting);

		// adding facilitator
		meeting.setFacilitator(memberEntity1);
		memberEntity1.getFacilitatedMeetings().add(meeting);

		// adding Heading1
		MomHeadingEntity heading1 = new MomHeadingEntity();
		heading1.setValue("Agenda");
		heading1.setSubHeadings(new ArrayList<MomHeadingEntity>());
		heading1.setMeeting(meeting);

		// adding subHeading1 under headings
		MomHeadingEntity subHeading1 = new MomHeadingEntity();
		subHeading1.setValue("Team Design");
		subHeading1.setParentHeading(heading1);

		// adding points under subheading1
		MomPointEntity point1 = new MomPointEntity();
		point1.setHeading(subHeading1);
		point1.setInfo("TEAM1 has Pranay");
		MomPointEntity point2 = new MomPointEntity();
		point2.setHeading(subHeading1);
		point2.setInfo("TEAM2 has Sandeep");
		subHeading1.setOrdered_points(false);
		subHeading1.setPoints(new ArrayList<MomPointEntity>());
		subHeading1.getPoints().add(point1);
		subHeading1.getPoints().add(point2);

		// adding subHeading2 under headings
		MomHeadingEntity subHeading2 = new MomHeadingEntity();
		subHeading2.setValue("Project Design");
		subHeading2.setParentHeading(heading1);

		// adding points under subheading2
		MomPointEntity point3 = new MomPointEntity();
		point3.setHeading(subHeading2);
		point3.setInfo("TEAM1 has MoM");
		MomPointEntity point4 = new MomPointEntity();
		point4.setHeading(subHeading2);
		point4.setInfo("TEAM2 has ECommerce");
		subHeading2.setOrdered_points(false);
		subHeading2.setPoints(new ArrayList<MomPointEntity>());
		subHeading2.getPoints().add(point3);
		subHeading2.getPoints().add(point4);

		heading1.getSubHeadings().add(subHeading1);
		heading1.getSubHeadings().add(subHeading2);

		// repeat the same process for heading 2
		MomHeadingEntity heading2 = new MomHeadingEntity();
		heading2.setValue("Closing");
		heading2.setSubHeadings(new ArrayList<MomHeadingEntity>());

		MomHeadingEntity subHeading3 = new MomHeadingEntity();
		subHeading3.setValue("Team Task");
		subHeading3.setParentHeading(heading2);
		MomPointEntity point5 = new MomPointEntity();
		point5.setHeading(subHeading3);
		point5.setInfo("TEAM1 has DTO");
		MomPointEntity point6 = new MomPointEntity();
		point6.setHeading(subHeading3);
		point6.setInfo("TEAM2 has ER");
		subHeading3.setOrdered_points(false);
		subHeading3.setPoints(new ArrayList<MomPointEntity>());
		subHeading3.getPoints().add(point5);
		subHeading3.getPoints().add(point6);

		MomHeadingEntity subHeading4 = new MomHeadingEntity();
		subHeading4.setValue("Project Name");
		subHeading4.setParentHeading(heading2);
		MomPointEntity point7 = new MomPointEntity();
		point7.setHeading(subHeading4);
		point7.setInfo("TEAM1 is MoM");
		MomPointEntity point8 = new MomPointEntity();
		point8.setHeading(subHeading4);
		point8.setInfo("TEAM2 is ECommerce");
		subHeading4.setOrdered_points(false);
		subHeading4.setPoints(new ArrayList<MomPointEntity>());
		subHeading4.getPoints().add(point7);
		subHeading4.getPoints().add(point8);

		heading2.getSubHeadings().add(subHeading3);
		heading2.getSubHeadings().add(subHeading4);

		// adding meeting to the organization
		meeting.setOrganizationEntity(organization);
		organization.setOrganizationMeetings(new ArrayList<OrganizationMeetingEntity>());
		organization.getOrganizationMeetings().add(meeting);

		// saving all entities
		organizationRepository.save(organization);

		organizationMemberRepository.save(memberEntity1);
		organizationMemberRepository.save(memberEntity2);

		organizationMeetingRepository.save(meeting);

		headingRepository.save(heading1);
		headingRepository.save(subHeading1);
		headingRepository.save(subHeading2);

		headingRepository.save(heading2);
		headingRepository.save(subHeading3);
		headingRepository.save(subHeading4);

		momPointRepository.save(point1);
		momPointRepository.save(point2);
		momPointRepository.save(point3);
		momPointRepository.save(point4);
		momPointRepository.save(point5);
		momPointRepository.save(point6);
		momPointRepository.save(point7);
		momPointRepository.save(point8);

		// mapping to respective Dtos to transfer to front end
		OrganizationCrudDto organizationDto = mapper.map(organization, OrganizationCrudDto.class);

		OrganizationMemberCrudDto memberDto1 = mapper.map(memberEntity1, OrganizationMemberCrudDto.class);
		OrganizationMemberCrudDto memberDto2 = mapper.map(memberEntity2, OrganizationMemberCrudDto.class);

		OrganizationMeetingCrudDto meetingDto = mapper.map(meeting, OrganizationMeetingCrudDto.class);

		organizationDto.getOrganizationMembers().add(memberDto1);
		organizationDto.getOrganizationMembers().add(memberDto2);

		organizationDto.setOrganizationMeetings(new ArrayList<OrganizationMeetingCrudDto>());
		organizationDto.getOrganizationMeetings().add(meetingDto);

		MomHeadingCrudDTO headingdto = mapper.map(heading1, MomHeadingCrudDTO.class);

		meetingDto.setHeadings(new ArrayList<MomHeadingCrudDTO>());
		meetingDto.getHeadings().add(headingdto);

		return organizationDto;
//		return organization;
	}

}
