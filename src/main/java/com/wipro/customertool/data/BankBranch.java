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
	private String description2;
	private String intercompany;
	private String mainBranchOfCountry;
	private String accountLocation;
	private String bic;
	private String corpIdCode;
	private String corpIdType;
	private String otherId;
	private String intermediary;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zip;
	private String state;
	private String homePage;
	private String bankContactName;
	private String bankcontactDepartment;
	private String bankcontactPhone;
	private String bankcontactFax;
	private String bankcontactEmail;
	private String interfaceCode;
	private String responderCode;
	private String serviceName;
	private String userZone1;
	private String userZone2;
	private String userZone3;
	private String userZone4;
	private String userZone5;
	private String memo;
}
