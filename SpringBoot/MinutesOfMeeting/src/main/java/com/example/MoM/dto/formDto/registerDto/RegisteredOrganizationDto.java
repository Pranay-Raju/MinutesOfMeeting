package com.example.MoM.dto.formDto.registerDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisteredOrganizationDto {
	
	private int organizationId;
	private String name;

}
