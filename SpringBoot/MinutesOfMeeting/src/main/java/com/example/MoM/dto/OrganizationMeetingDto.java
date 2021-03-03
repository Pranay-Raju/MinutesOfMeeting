package com.example.MoM.dto;

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

public class OrganizationMeetingDto {

	private int id;
	private String meetingName;
	private String organizationName;
	private OrganizationMemberDto facilitator;
	private Date startDateAndTime;
	private Date endDateAndTime;
	private List<OrganizationMemberDto> attendees;
	private List<MomHeadingDTO> headings;

}
