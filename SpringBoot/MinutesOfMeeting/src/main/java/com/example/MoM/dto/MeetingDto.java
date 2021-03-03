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

public class MeetingDto {

	private int meetingId;
	private String name;
	private String organizationName;
	private MemberDto facilitator;
	private Date startDateAndTime;
	private Date endDateAndTime;
	private List<MemberDto> attendees;
	private List<MomHeadingDTO> headings;

}
