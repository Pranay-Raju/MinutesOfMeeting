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
public class RegisterFormDto {
	
	private int organizationId;
	private String organizationName;
	private String organizationDomain;
	private String organizationMobileNo;
	private String organizationAddress;
	

	private int memberId;
	private String name;
	private String mobileNo;
	private String role;
	private String address;
	private String gender;
	private String loginId;
	private String password;

}
