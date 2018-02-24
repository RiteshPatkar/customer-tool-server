package com.wipro.customertool.data;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Calendar {
	
	private Integer id;
	private String userId;
	private String countryCode;

	private String calendarCode;
	private String calendarDescription;
	private String closedDays;
	
	private List<BankHoliday> datesAndFlags;
	
}
