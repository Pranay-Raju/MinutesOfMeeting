package com.example.MoM;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.MoM.dto.MemberDto;
import com.example.MoM.dto.MomHeadingDTO;
import com.example.MoM.dto.OrganizationDto;
import com.example.MoM.entity.MomHeadingEntity;
import com.example.MoM.entity.OrganizationEntity;
import com.example.MoM.entity.OrganizationMemberEntity;

@SpringBootApplication
public class MinutesOfMeetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinutesOfMeetingApplication.class, args);
	}

	@Bean
	public ModelMapper createModelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<OrganizationMemberEntity, MemberDto>() {

			@Override
			protected void configure() {
				map().setOrganisationName(source.getOrganizationEntity().getOrganizationName());

			}
		});

		mapper.addMappings(new PropertyMap<OrganizationEntity, OrganizationDto>() {

			@Override
			protected void configure() {
				OrganizationDto dto = map();
				dto.setOrganizationMembers(new ArrayList<MemberDto>());

			}
		});
		
		mapper.addMappings(new PropertyMap<MomHeadingEntity, MomHeadingDTO>() {

			@Override
			protected void configure() {
				MomHeadingDTO dto = map();
				dto.setParent_heading_id(source.getParentHeading().getId());

			}
		});

		return mapper;
	}

}
