package com.example.MoM.dto.formDto.minutesDto.pointDto;

import com.example.MoM.dto.formDto.minutesDto.headingDto.HeadingDto;
import com.example.MoM.dto.formDto.minutesDto.headingDto.HeadingMeetingDto;

import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PointDto {
	
	private int id;
	private String value;
	private HeadingDto heading;
	private HeadingMeetingDto meeting;

}
