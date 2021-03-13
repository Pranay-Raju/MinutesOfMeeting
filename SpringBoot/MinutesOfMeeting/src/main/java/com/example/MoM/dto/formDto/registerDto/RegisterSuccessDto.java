package com.example.MoM.dto.formDto.registerDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterSuccessDto {

	private RegisteredOrganizationDto organization;
	private RegisteredMemberDto member;
}
