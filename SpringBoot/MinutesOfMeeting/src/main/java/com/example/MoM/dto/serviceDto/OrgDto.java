package com.example.MoM.dto.serviceDto;

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
public class OrgDto {
	
	private int organizationId;
	private String organizationName;
	private String organizationDomain;
	private String organizationMobileNo;
	private String organizationAddress;

}
