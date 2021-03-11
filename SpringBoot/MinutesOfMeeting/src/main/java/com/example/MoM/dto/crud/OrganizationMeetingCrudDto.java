package com.example.MoM.dto.crud;

import java.util.Date;
import java.util.List;

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

public class OrganizationMeetingCrudDto {

	private int id;
	private String meetingName;
	private String organizationName;
	private OrganizationMemberCrudDto facilitator;
	private Date startDateAndTime;
	private Date endDateAndTime;
	private List<OrganizationMemberCrudDto> attendees;
	private List<MomHeadingCrudDTO> headings;

}
