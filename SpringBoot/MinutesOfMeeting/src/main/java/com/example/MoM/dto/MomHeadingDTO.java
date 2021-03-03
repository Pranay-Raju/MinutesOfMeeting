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
@ToString
@NoArgsConstructor
public class MomHeadingDTO {
	
	private int id;
	
	private String value;
	private int parent_heading_id;
	
	private List<MomHeadingDTO> subHeadings;
	
	private List<MomPointsDto> points;

}
