package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BankBranch {
	
	private String action;
	private String bankBranchCode;
	private String bankCode;
	private String calendarCode;
	private String countryCode;
	private String userId;
	
	private String description;
}
