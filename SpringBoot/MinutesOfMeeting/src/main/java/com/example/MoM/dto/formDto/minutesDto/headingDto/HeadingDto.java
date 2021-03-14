package com.example.MoM.dto.formDto.minutesDto.headingDto;

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
public class HeadingDto {
	
	private int id;
	private String value;
	private HeadingMeetingDto meeting;
	private HeadingDto parent;

}
