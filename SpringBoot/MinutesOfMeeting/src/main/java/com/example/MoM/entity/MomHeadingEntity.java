package com.example.MoM.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Entity(name = "heading")
public class MomHeadingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne
//	@JoinColumn(name = "mom_id")
//	private MomEntity mom;
	
	@ManyToOne
	@JoinColumn(name = "meeting_id")
	private OrganizationMeetingEntity meeting;
	
	private String value;
	
	@OneToMany(mappedBy = "parentHeading")
	private List<MomHeadingEntity> subHeadings;
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private MomHeadingEntity parentHeading;
	
	private Boolean ordered_points;
	
	@OneToMany(mappedBy = "heading")
	private List<MomPointEntity> points;

}
