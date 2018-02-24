package com.wipro.customertool.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class CalendarEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String calendarCode;
	private String countryCode;
	private String userId;
	private String calendarDescription;
	private String closedDays;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="CALENDAR_ID", referencedColumnName="ID")
	private List<BankHolidayEntity> datesAndFlags;
	
}
