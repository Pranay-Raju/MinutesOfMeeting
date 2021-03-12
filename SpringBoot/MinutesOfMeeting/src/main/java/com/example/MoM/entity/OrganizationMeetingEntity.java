package com.example.MoM.entity;

import java.util.Date;
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
@ToString(exclude = {"attendees","organizationEntity","facilitator","headings"})
@Entity(name = "Meeting")
public class OrganizationMeetingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private OrganizationEntity organizationEntity;

	private String meetingName;

	@ManyToOne
	@JoinColumn(name = "facilitator_id")
	private OrganizationMemberEntity facilitator;

	private Date startDateAndTime;
	private Date endDateAndTime;

	@ManyToMany
	private List<OrganizationMemberEntity> attendees;


	@OneToMany(mappedBy = "meeting")
	private List<MomHeadingEntity> headings;

}
