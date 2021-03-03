package com.example.MoM;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MinutesOfMeetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinutesOfMeetingApplication.class, args);
	}

	@Bean
	public ModelMapper createModelMapper() {
		ModelMapper mapper = new ModelMapper();
//		mapper.addMappings(new PropertyMap<OrganizationMemberEntity, OrganizationMemberDto>() {
//
//			@Override
//			protected void configure() {
//				map().setOrganisationName(source.getOrganizationEntity().getOrganizationName());
//
//			}
//		});
//
//		mapper.addMappings(new PropertyMap<OrganizationEntity, OrganizationDto>() {
//
//			@Override
//			protected void configure() {
//				OrganizationDto dto = map();
//				dto.setOrganizationMembers(new ArrayList<OrganizationMemberDto>());
//
//			}
//		});

//		mapper.addMappings(new PropertyMap<MomHeadingEntity, MomHeadingDTO>() {
//
//			@Override
//			protected void configure() {
//				MomHeadingDTO dto = map();
//				dto.setParent_heading_id(source.getParentHeading().getId());
//
//			}
//		});
//
		return mapper;
	}

}
