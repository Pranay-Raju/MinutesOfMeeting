package com.example.MoM;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.MoM.dto.formDto.MeetingFormDto;
import com.example.MoM.dto.formDto.MemberFormDto;
import com.example.MoM.dto.formDto.registerDto.RegisterFormDto;
import com.example.MoM.entity.OrganizationMeetingEntity;
import com.example.MoM.entity.OrganizationMemberEntity;

@SpringBootApplication
public class MinutesOfMeetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinutesOfMeetingApplication.class, args);
	}

	@Bean
	public ModelMapper createModelMapper() {
		ModelMapper mapper = new ModelMapper();

		mapper.addMappings(new PropertyMap<RegisterFormDto, OrganizationMemberEntity>() {

			@Override
			protected void configure() {
				map().setOrganizationRole(source.getRole());
				map().setMemberName(source.getName());
			}
		});

		mapper.addMappings(new PropertyMap<MemberFormDto, OrganizationMemberEntity>() {

			@Override
			protected void configure() {
				map().setOrganizationRole(source.getRole());
			}
		});

		mapper.addMappings(new PropertyMap<MeetingFormDto, OrganizationMeetingEntity>() {

			@Override
			protected void configure() {
				map().setMeetingName(source.getName());
			}
		});

		return mapper;
	}

}
