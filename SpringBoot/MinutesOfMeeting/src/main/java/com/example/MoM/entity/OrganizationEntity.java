package com.example.MoM.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@ToString(exclude = {"organizationMembers","organizationMeetings"})
@Entity(name = "organization")
public class OrganizationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int organizationId;
	@Column(unique = true)
	private String organizationName;
	private String organizationDomain;
	private String organizationMobileNo;
	private String organizationAddress;

	@OneToMany(mappedBy = "organizationEntity")
	private List<OrganizationMemberEntity> organizationMembers;

	@OneToMany(mappedBy = "organizationEntity")
	private List<OrganizationMeetingEntity> organizationMeetings;

}
