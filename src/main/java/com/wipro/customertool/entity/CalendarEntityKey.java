package com.wipro.customertool.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CalendarEntityKey {
	
	private String flag;
	private String calendarCode;
	private String countryCode;
	private String userId;
}
