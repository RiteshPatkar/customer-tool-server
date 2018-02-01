package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Account {
	
	private String action;
	private String accountCode;
	private String currencyCode;
	private String companyCode;
	private String bankBranchCode;
	private String countryCode;
	private String calendarCode;
	private String userId;
	
	private String rejectCode;
	private String accountType;
	private String description;
	private String issuerNumber;
	private String bankLayout;
	private String accountIdType;
	private String paymentAccountId;
	private String statementAccountNumber;
	private String accountIdDescription;
	private String stree1;
	private String street2;
	private String city;
	private String zip;
	private String state;
	private String homePage;
	private String name;
	private String department;
	private String contactPhoneNumber;
	private String contactFaxNumber;
	private String contactEmail;
	private String zbaGenerator;
	private String zbaIdentifier;
	private String generateZbaFlow;
	private String chartOfAccount;
	private String glCode;
	private String internalGlAccount;
	private String considorOneDayFloatTransactions;
	private String considorTwoDayFloatTransactions;
	private String description2;
	private String establishment;
	private String establishmentAccount;
	private String considorThreeDayFloatTransactions;
	private String considorInvestmentPositionTransactions;
	private String integrateEndOfDayStatements;
	private String integrateIntraDayStatements;
	private String closedAccount;
	private String closingDate;
	private String defaultAccountGroup;
	private String internationalTransfer;
	private String MaturityTransfer;
	private String domesticDirectDebit;
	private String internationalDirectDebit;
	private String payableDrafts;
	private String receivableDrafts;
	private String includeAccountInGLReconciliation;
	private String considorBankStatementsFron;
	private String initialAccountingBalance;
	private String initialAccountingBalanceDate;
	private String settlementAccount;
	private String counterPartySettlementAccount;
	private String accountCategory1;
	private String accountCategory2;
	private String accountCategory3;
	private String accountCategory4;
	private String accountCategory5;
	private String accountCategory6;
	private String accountCategory7;
	private String accountCategory8;
	private String accountCategory9;
	private String accountCategory10;
	private String userZone1;
	private String userZone2;
	private String userZone3;
	private String userZone4;
	private String userZone5;
	private String freeStatementIdentifier;
	private String interestBearing;
	private String centrallymanaged;
	private String ownerName;
	private String reconcilerName;
	private String freetext1;
	private String freetext2;
	private String freetext3;
	private String freeAmount1;
	private String freeAmount2;
	private String freeAmount3;
	private String accountAvailableForPayments;
	private String accountNature;
	
}
