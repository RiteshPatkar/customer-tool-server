package com.wipro.customertool.data;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CompanyEntityKey {
	
	private String action;
	private String companyCode;
	private String shortCode;
	private String currencyCode;
	private String glCurrencyCode;
	private String countryCode;
	private String userId;
}
