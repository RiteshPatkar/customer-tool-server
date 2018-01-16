package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Company {
	
	private String action;
	private String companyCode;
	private String shortCode;
	private String currencyCode;
	private String glCurrencyCode;
	private String countryCode;
	private String userId;
	
	private String rejectCode;
	private String description;
	private String description2;
	private String corporateCodeId;
	private String txp;
	private String otherIdType;
	private String otherId;
	private String nonResident;
	private String issuerOfInterchange;
	private String glCurrencyRate;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zip;
	private String state;
	private String homePage;
	private String contactName;
	private String contactDepartment;
	private String contactPhoneNumber;
	private String contactFaxNumber;
	private String contactEmail;
	private String intermediary;
	private String counterParty;
	private String contact;
	private String companyConsolidationCode;
	private String interfaceCode;
	private String legalForm;
	private String capital;
	private String legalrepresentative1;
	private String position1;
	private String legalrepresentative2;
	private String position2;
	private String legalFreeText1;
	private String legalFreeText2;
	private String legalFreeText3;
	private String legalFreeText4;
	private String legalFreeText5;
	private String bei;
	private String defaultGroup;
	private String sepaCreditorIdentifier;
	private String lei;
	private String accountingCalendar;
	private String distinguishedName;
	
}
