package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.Account;
import com.wipro.customertool.data.Accounts;
import com.wipro.customertool.entity.AccountEntity;
import com.wipro.customertool.repository.AccountRepository;
import com.wipro.customertool.repository.CountryRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	public Accounts getAccountsByUserIdAndCountryCodes(final String userId, final String[] countryCodes) {
		
		List<AccountEntity> accountEntities = null;
		
		
		if(null == countryCodes) {
			String[] retrievedCountryCodes = countryRepository.getcountryCodesForYFlag(Integer.valueOf(userId));
			if(null != retrievedCountryCodes && retrievedCountryCodes.length > 0) {
				accountEntities =  accountRepository.findByUserIdAndCountryCodeIn(userId, Arrays.asList(retrievedCountryCodes));
			} else {
				accountEntities =  accountRepository.findByUserId(userId);
			}
		}
		else {
			accountEntities =  accountRepository.findByUserIdAndCountryCodeIn(userId, Arrays.asList(countryCodes));
		}
		return new Accounts().setAccounts(buildTOFromEntites(accountEntities));
	}

	public void saveAccounts(Accounts input) {
		List<Account> accounts = input.getAccounts();
		List<AccountEntity> accountEntities = buildEntitesFromTO(accounts);
		accountRepository.save(accountEntities);
	}

	public void deleteAccountById(Integer id) {
		accountRepository.delete(new AccountEntity().setId(id));
	}
	
	private List<Account> buildTOFromEntites(List<AccountEntity> entities) {
		List<Account> accounts = new ArrayList<>();
		
		for (AccountEntity entity : entities) {
			Account account = new Account();
			
			account.setAction(entity.getAction());
			account.setAccountCode(entity.getAccountCode());
			account.setCurrencyCode(entity.getCurrencyCode());
			account.setCompanyCode(entity.getCompanyCode());
			account.setBankBranchCode(entity.getBankBranchCode());
			account.setCountryCode(entity.getCountryCode());
			account.setCalendarCode(entity.getCalendarCode());
			account.setUserId(entity.getUserId());
			account.setRejectCode(entity.getRejectCode());
			account.setAccountType(entity.getAccountType());
			account.setDescription(entity.getDescription());
			account.setIssuerNumber(entity.getIssuerNumber());
			account.setBankLayout(entity.getBankLayout());
			account.setAccountIdType(entity.getAccountIdType());
			account.setPaymentAccountId(entity.getPaymentAccountId());
			account.setStatementAccountNumber(entity.getStatementAccountNumber());
			account.setAccountIdDescription(entity.getAccountIdDescription());
			account.setStree1(entity.getStree1());
			account.setStreet2(entity.getStreet2());
			account.setCity(entity.getCity());
			account.setZip(entity.getZip());
			account.setState(entity.getState());
			account.setHomePage(entity.getHomePage());
			account.setName(entity.getName());
			account.setDepartment(entity.getDepartment());
			account.setContactPhoneNumber(entity.getContactPhoneNumber());
			account.setContactFaxNumber(entity.getContactFaxNumber());
			account.setContactEmail(entity.getContactEmail());
			account.setZbaGenerator(entity.getZbaGenerator());
			account.setZbaIdentifier(entity.getZbaIdentifier());
			account.setGenerateZbaFlow(entity.getGenerateZbaFlow());
			account.setChartOfAccount(entity.getChartOfAccount());
			account.setGlCode(entity.getGlCode());
			account.setInternalGlAccount(entity.getInternalGlAccount());
			account.setConsidorOneDayFloatTransactions(entity.getConsidorOneDayFloatTransactions());
			account.setConsidorTwoDayFloatTransactions(entity.getConsidorTwoDayFloatTransactions());
			account.setDescription2(entity.getDescription2());
			account.setEstablishment(entity.getEstablishment());
			account.setEstablishmentAccount(entity.getEstablishmentAccount());
			account.setConsidorThreeDayFloatTransactions(entity.getConsidorThreeDayFloatTransactions());
			account.setConsidorInvestmentPositionTransactions(entity.getConsidorInvestmentPositionTransactions());
			account.setIntegrateEndOfDayStatements(entity.getIntegrateEndOfDayStatements());
			account.setIntegrateIntraDayStatements(entity.getIntegrateIntraDayStatements());
			account.setClosedAccount(entity.getClosedAccount());
			account.setClosingDate(entity.getClosingDate());
			account.setDefaultAccountGroup(entity.getDefaultAccountGroup());
			account.setInternationalTransfer(entity.getInternationalTransfer());
			account.setMaturityTransfer(entity.getMaturityTransfer());
			account.setDomesticDirectDebit(entity.getDomesticDirectDebit());
			account.setInternationalDirectDebit(entity.getInternationalDirectDebit());
			account.setPayableDrafts(entity.getPayableDrafts());
			account.setReceivableDrafts(entity.getReceivableDrafts());
			account.setIncludeAccountInGLReconciliation(entity.getIncludeAccountInGLReconciliation());
			account.setConsidorBankStatementsFron(entity.getConsidorBankStatementsFron());
			account.setInitialAccountingBalance(entity.getInitialAccountingBalance());
			account.setInitialAccountingBalanceDate(entity.getInitialAccountingBalanceDate());
			account.setSettlementAccount(entity.getSettlementAccount());
			account.setCounterPartySettlementAccount(entity.getCounterPartySettlementAccount());
			account.setAccountCategory1(entity.getAccountCategory1());
			account.setAccountCategory2(entity.getAccountCategory2());
			account.setAccountCategory3(entity.getAccountCategory3());
			account.setAccountCategory4(entity.getAccountCategory4());
			account.setAccountCategory5(entity.getAccountCategory5());
			account.setAccountCategory6(entity.getAccountCategory6());
			account.setAccountCategory7(entity.getAccountCategory7());
			account.setAccountCategory8(entity.getAccountCategory8());
			account.setAccountCategory9(entity.getAccountCategory9());
			account.setAccountCategory10(entity.getAccountCategory10());
			account.setUserZone1(entity.getUserZone1());
			account.setUserZone2(entity.getUserZone2());
			account.setUserZone3(entity.getUserZone3());
			account.setUserZone4(entity.getUserZone4());
			account.setUserZone5(entity.getUserZone5());
			account.setFreeStatementIdentifier(entity.getFreeStatementIdentifier());
			account.setInterestBearing(entity.getInterestBearing());
			account.setCentrallymanaged(entity.getCentrallymanaged());
			account.setOwnerName(entity.getOwnerName());
			account.setReconcilerName(entity.getReconcilerName());
			account.setFreetext1(entity.getFreetext1());
			account.setFreetext2(entity.getFreetext2());
			account.setFreetext3(entity.getFreetext3());
			account.setFreeAmount1(entity.getFreeAmount1());
			account.setFreeAmount2(entity.getFreeAmount2());
			account.setFreeAmount3(entity.getFreeAmount3());
			account.setAccountAvailableForPayments(entity.getAccountAvailableForPayments());
			account.setAccountNature(entity.getAccountNature());
			
			accounts.add(account);
		}
		return accounts;
	}
	
	private List<AccountEntity> buildEntitesFromTO(List<Account> accounts) {
		List<AccountEntity> entities = new ArrayList<>();
		
		for (Account account : accounts) {
			AccountEntity entity = new AccountEntity();
			
			entity.setId(account.getId());
			
			entity.setAction(account.getAction());
			entity.setAccountCode(account.getAccountCode());
			entity.setCurrencyCode(account.getCurrencyCode());
			entity.setCompanyCode(account.getCompanyCode());
			entity.setBankBranchCode(account.getBankBranchCode());
			entity.setCountryCode(account.getCountryCode());
			entity.setCalendarCode(account.getCalendarCode());
			entity.setUserId(account.getUserId());
			entity.setRejectCode(account.getRejectCode());
			entity.setAccountType(account.getAccountType());
			entity.setDescription(account.getDescription());
			entity.setIssuerNumber(account.getIssuerNumber());
			entity.setBankLayout(account.getBankLayout());
			entity.setAccountIdType(account.getAccountIdType());
			entity.setPaymentAccountId(account.getPaymentAccountId());
			entity.setStatementAccountNumber(account.getStatementAccountNumber());
			entity.setAccountIdDescription(account.getAccountIdDescription());
			entity.setStree1(account.getStree1());
			entity.setStreet2(account.getStreet2());
			entity.setCity(account.getCity());
			entity.setZip(account.getZip());
			entity.setState(account.getState());
			entity.setHomePage(account.getHomePage());
			entity.setName(account.getName());
			entity.setDepartment(account.getDepartment());
			entity.setContactPhoneNumber(account.getContactPhoneNumber());
			entity.setContactFaxNumber(account.getContactFaxNumber());
			entity.setContactEmail(account.getContactEmail());
			entity.setZbaGenerator(account.getZbaGenerator());
			entity.setZbaIdentifier(account.getZbaIdentifier());
			entity.setGenerateZbaFlow(account.getGenerateZbaFlow());
			entity.setChartOfAccount(account.getChartOfAccount());
			entity.setGlCode(account.getGlCode());
			entity.setInternalGlAccount(account.getInternalGlAccount());
			entity.setConsidorOneDayFloatTransactions(account.getConsidorOneDayFloatTransactions());
			entity.setConsidorTwoDayFloatTransactions(account.getConsidorTwoDayFloatTransactions());
			entity.setDescription2(account.getDescription2());
			entity.setEstablishment(account.getEstablishment());
			entity.setEstablishmentAccount(account.getEstablishmentAccount());
			entity.setConsidorThreeDayFloatTransactions(account.getConsidorThreeDayFloatTransactions());
			entity.setConsidorInvestmentPositionTransactions(account.getConsidorInvestmentPositionTransactions());
			entity.setIntegrateEndOfDayStatements(account.getIntegrateEndOfDayStatements());
			entity.setIntegrateIntraDayStatements(account.getIntegrateIntraDayStatements());
			entity.setClosedAccount(account.getClosedAccount());
			entity.setClosingDate(account.getClosingDate());
			entity.setDefaultAccountGroup(account.getDefaultAccountGroup());
			entity.setInternationalTransfer(account.getInternationalTransfer());
			entity.setMaturityTransfer(account.getMaturityTransfer());
			entity.setDomesticDirectDebit(account.getDomesticDirectDebit());
			entity.setInternationalDirectDebit(account.getInternationalDirectDebit());
			entity.setPayableDrafts(account.getPayableDrafts());
			entity.setReceivableDrafts(account.getReceivableDrafts());
			entity.setIncludeAccountInGLReconciliation(account.getIncludeAccountInGLReconciliation());
			entity.setConsidorBankStatementsFron(account.getConsidorBankStatementsFron());
			entity.setInitialAccountingBalance(account.getInitialAccountingBalance());
			entity.setInitialAccountingBalanceDate(account.getInitialAccountingBalanceDate());
			entity.setSettlementAccount(account.getSettlementAccount());
			entity.setCounterPartySettlementAccount(account.getCounterPartySettlementAccount());
			entity.setAccountCategory1(account.getAccountCategory1());
			entity.setAccountCategory2(account.getAccountCategory2());
			entity.setAccountCategory3(account.getAccountCategory3());
			entity.setAccountCategory4(account.getAccountCategory4());
			entity.setAccountCategory5(account.getAccountCategory5());
			entity.setAccountCategory6(account.getAccountCategory6());
			entity.setAccountCategory7(account.getAccountCategory7());
			entity.setAccountCategory8(account.getAccountCategory8());
			entity.setAccountCategory9(account.getAccountCategory9());
			entity.setAccountCategory10(account.getAccountCategory10());
			entity.setUserZone1(account.getUserZone1());
			entity.setUserZone2(account.getUserZone2());
			entity.setUserZone3(account.getUserZone3());
			entity.setUserZone4(account.getUserZone4());
			entity.setUserZone5(account.getUserZone5());
			entity.setFreeStatementIdentifier(account.getFreeStatementIdentifier());
			entity.setInterestBearing(account.getInterestBearing());
			entity.setCentrallymanaged(account.getCentrallymanaged());
			entity.setOwnerName(account.getOwnerName());
			entity.setReconcilerName(account.getReconcilerName());
			entity.setFreetext1(account.getFreetext1());
			entity.setFreetext2(account.getFreetext2());
			entity.setFreetext3(account.getFreetext3());
			entity.setFreeAmount1(account.getFreeAmount1());
			entity.setFreeAmount2(account.getFreeAmount2());
			entity.setFreeAmount3(account.getFreeAmount3());
			entity.setAccountAvailableForPayments(account.getAccountAvailableForPayments());
			entity.setAccountNature(account.getAccountNature());
			
			entities.add(entity);
		}
		return entities;
	}

}
