package com.example.MoM.dto.crud;

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
public class OrganizationCrudDto {

	private int organizationId;
	private String organizationName;
	private String organizationDomain;
	private String organizationMobileNo;
	private String organizationAddress;
	private List<OrganizationMemberCrudDto> organizationMembers;
	private List<OrganizationMeetingCrudDto> organizationMeetings;

}
