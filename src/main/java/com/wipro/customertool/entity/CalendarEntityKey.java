package com.wipro.customertool.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CalendarEntityKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String flag;
	private String calendarCode;
	private String countryCode;
	private String userId;
}
