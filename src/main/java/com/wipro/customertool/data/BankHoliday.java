package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BankHoliday {
	
	private Integer id;
	private String flag;
	private String date;
}
