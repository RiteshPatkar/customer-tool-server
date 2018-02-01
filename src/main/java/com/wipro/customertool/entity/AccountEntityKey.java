package com.wipro.customertool.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AccountEntityKey implements Serializable {
	
	private String action;
	private String accountCode;
	private String currencyCode;
	private String companyCode;
	private String bankBranchCode;
	private String countryCode;
	private String calendarCode;
	private String userId;
}
