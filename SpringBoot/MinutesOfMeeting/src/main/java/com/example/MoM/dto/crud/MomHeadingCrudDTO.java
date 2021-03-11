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
@ToString
@NoArgsConstructor
public class MomHeadingCrudDTO {
	
	private int id;
	
	private String value;
	private int parent_heading_id;
	
	private List<MomHeadingCrudDTO> subHeadings;
	
	private List<MomPointsCrudDto> points;

}
