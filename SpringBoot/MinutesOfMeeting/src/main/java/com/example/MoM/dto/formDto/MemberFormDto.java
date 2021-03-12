package com.example.MoM.dto.formDto;

import com.example.MoM.dto.crud.OrganizationCrudDto;

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
public class MemberFormDto {
	
	private int memberId;
	private String name;
	private OrganizationCrudDto organization;
	private String mailId;
	private String mobileNo;
	private String role;
	private String address;
	private String gender;
	private String loginId;
	private String password;

}
