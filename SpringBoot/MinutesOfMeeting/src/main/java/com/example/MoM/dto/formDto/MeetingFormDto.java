package com.example.MoM.dto.formDto;

import com.example.MoM.dto.crud.OrganizationCrudDto;
import com.example.MoM.dto.crud.OrganizationMemberCrudDto;

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
public class MeetingFormDto {
	
	private int meetingId;
	private String name;
	private OrganizationCrudDto organization;
	private OrganizationMemberCrudDto facilitator;

}
