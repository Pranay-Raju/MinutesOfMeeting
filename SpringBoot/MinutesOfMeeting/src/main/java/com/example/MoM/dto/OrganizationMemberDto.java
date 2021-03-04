package com.example.MoM.dto;

import javax.persistence.Column;

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
public class OrganizationMemberDto {

	private int memberId;
	private String name;
	private String organizationName;
	private String mobileNo;
	private String role;
	private String address;
	private String gender;
	@Column(unique = true)
	private String loginId;
	private String password;

}
