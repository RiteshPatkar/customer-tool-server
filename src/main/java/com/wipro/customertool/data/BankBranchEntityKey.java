package com.wipro.customertool.data;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BankBranchEntityKey {
	
	private String action;
	private String bankBranchCode;
	private String bankCode;
	private String calendarCode;
	private String countryCode;
	private String userId;
}
