package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Calendar {
	
	private Integer id;
	
	private String flag;
	private String calendarCode;
	private String countryCode;
	private String userId;
	
	private String description;
}
