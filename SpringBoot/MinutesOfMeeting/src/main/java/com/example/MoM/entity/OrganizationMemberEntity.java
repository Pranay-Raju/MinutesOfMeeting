package com.example.MoM.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@Entity(name = "memeber")
public class OrganizationMemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int organizationMemberId;
	
	private String memberName;
	
	private String organizationMailId;
	private String organizationMobileNo;
	private String organizationRole;
	private String Address;
	private String Gender;
	private String loginId;
	private String password;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private OrganizationEntity organizationEntity;
	
	
	@OneToMany(mappedBy = "facilitator")
	private List<OrganizationMeetingEntity> facilitatedMeetings;
	
	@ManyToMany(mappedBy = "attendees")
	private List<OrganizationMeetingEntity> attendedMeetings;

}
