package com.example.MoM.dto;

import java.util.List;

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
public class OrganizationDto {

	private int organizationId;
	private String organizationName;
	private String organizationDomain;
	private String organizationMobileNo;
	private String organizationAddress;
	private List<OrganizationMemberDto> organizationMembers;
	private List<OrganizationMeetingDto> organizationMeetings;

}
