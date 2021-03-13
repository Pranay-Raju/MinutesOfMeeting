package com.example.MoM.dto.formDto.registerDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredMemberDto {

	private int memberId;
	private String name,role,loginId,password;
	

}
