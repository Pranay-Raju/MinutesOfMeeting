package com.example.MoM.dto.formDto.minutesDto.response;

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
public class MomResponseMeetingDto {
	
	private int id;
	private String name;
	private List<MomResponseHeadingDto> headings;

}
