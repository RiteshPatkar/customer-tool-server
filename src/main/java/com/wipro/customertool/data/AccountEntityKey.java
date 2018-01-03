package com.wipro.customertool.data;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AccountEntityKey {
	
	private String action;
	private String accountCode;
	private String currencyCode;
	private String companyCode;
	private String bankBranchCode;
	private String countryCode;
	private String calendarCode;
	private String userId;
}
