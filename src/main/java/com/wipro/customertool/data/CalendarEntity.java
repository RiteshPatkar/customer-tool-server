package com.wipro.customertool.data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class CalendarEntity {
	
	@EmbeddedId
	private CalendarEntityKey id;
	
	private String description;
}
