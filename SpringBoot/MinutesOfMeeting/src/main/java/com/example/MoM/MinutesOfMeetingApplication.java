package com.example.MoM;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.MoM.dto.OrganizationDto;
import com.example.MoM.dto.OrganizationMemberDto;
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

		mapper.addMappings(new PropertyMap<OrganizationMemberEntity, OrganizationMemberDto>() {

			@Override
			protected void configure() {
				map().setOrganizationName(source.getOrganizationEntity().getOrganizationName());
			}
		});
		
		
		
		
		return mapper;
	}

}
