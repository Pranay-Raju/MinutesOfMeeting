package com.example.MoM.dto.crud;

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
public class OrganizationMemberCrudDto {

	private int memberId;
	private String name;
	private String organizationName;
	private String mobileNo;
	private String role;
	private String address;
	private String gender;
	private String loginId;
	private String password;

}
