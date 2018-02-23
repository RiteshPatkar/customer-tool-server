package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.Companies;
import com.wipro.customertool.data.Company;
import com.wipro.customertool.entity.CompanyEntity;
import com.wipro.customertool.repository.CompanyRepository;
import com.wipro.customertool.repository.CountryRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	CountryRepository countryRepository;

	public Companies getCompaniesByUserIdAndCountryCodes(final String userId, final String[] countryCodes) {

		List<CompanyEntity> companyEntities = null;

		if (null == countryCodes) {
			String[] retrievedCountryCodes = countryRepository.getcountryCodesForYFlag(Integer.valueOf(userId));
			if (null != retrievedCountryCodes && retrievedCountryCodes.length > 0) {
				companyEntities = companyRepository.findByUserIdAndCountryCodeIn(userId,
						Arrays.asList(retrievedCountryCodes));
			} else {
				companyEntities = companyRepository.findByUserId(userId);
			}
		} else {
			companyEntities = companyRepository.findByUserIdAndCountryCodeIn(userId, Arrays.asList(countryCodes));
		}
		return new Companies().setCompanies(buildTOFromEntites(companyEntities));
	}

	public void saveCompanies(Companies input) {
		List<Company> Companies = input.getCompanies();
		List<CompanyEntity> companyEntities = buildEntitesFromTO(Companies);
		companyRepository.save(companyEntities);
	}

	public void deleteCompanyById(Integer id) {
		companyRepository.delete(new CompanyEntity().setId(id));
	}

	private List<Company> buildTOFromEntites(List<CompanyEntity> entities) {
		List<Company> companies = new ArrayList<>();

		for (CompanyEntity entity : entities) {
			Company company = new Company();

			company.setId(entity.getId());
			company.setAction(entity.getAction());
			company.setCompanyCode(entity.getCompanyCode());
			company.setShortCode(entity.getShortCode());
			company.setCurrencyCode(entity.getCurrencyCode());
			company.setGlCurrencyCode(entity.getGlCurrencyCode());
			company.setCountryCode(entity.getCountryCode());
			company.setUserId(entity.getUserId());
			company.setRejectCode(entity.getRejectCode());
			company.setDescription(entity.getDescription());
			company.setDescription2(entity.getDescription2());
			company.setCorporateCodeId(entity.getCorporateCodeId());
			company.setTxp(entity.getTxp());
			company.setOtherIdType(entity.getOtherIdType());
			company.setOtherId(entity.getOtherId());
			company.setNonResident(entity.getNonResident());
			company.setIssuerOfInterchange(entity.getIssuerOfInterchange());
			company.setGlCurrencyRate(entity.getGlCurrencyRate());
			company.setAddressLine1(entity.getAddressLine1());
			company.setAddressLine2(entity.getAddressLine2());
			company.setCity(entity.getCity());
			company.setZip(entity.getZip());
			company.setState(entity.getState());
			company.setHomePage(entity.getHomePage());
			company.setContactName(entity.getContactName());
			company.setContactDepartment(entity.getContactDepartment());
			company.setContactPhoneNumber(entity.getContactPhoneNumber());
			company.setContactFaxNumber(entity.getContactFaxNumber());
			company.setContactEmail(entity.getContactEmail());
			company.setIntermediary(entity.getIntermediary());
			company.setCounterParty(entity.getCounterParty());
			company.setContact(entity.getContact());
			company.setCompanyConsolidationCode(entity.getCompanyConsolidationCode());
			company.setInterfaceCode(entity.getInterfaceCode());
			company.setLegalForm(entity.getLegalForm());
			company.setCapital(entity.getCapital());
			company.setLegalRepresentative1(entity.getLegalRepresentative1());
			company.setPosition1(entity.getPosition1());
			company.setLegalRepresentative2(entity.getLegalRepresentative2());
			company.setPosition2(entity.getPosition2());
			company.setLegalFreeText1(entity.getLegalFreeText1());
			company.setLegalFreeText2(entity.getLegalFreeText2());
			company.setLegalFreeText3(entity.getLegalFreeText3());
			company.setLegalFreeText4(entity.getLegalFreeText4());
			company.setLegalFreeText5(entity.getLegalFreeText5());
			company.setBei(entity.getBei());
			company.setDefaultGroup(entity.getDefaultGroup());
			company.setSepaCreditorIdentifier(entity.getSepaCreditorIdentifier());
			company.setLei(entity.getLei());
			company.setAccountingCalendar(entity.getAccountingCalendar());
			company.setDistinguishedName(entity.getDistinguishedName());

			companies.add(company);
		}
		return companies;
	}

	private List<CompanyEntity> buildEntitesFromTO(List<Company> companys) {
		List<CompanyEntity> entities = new ArrayList<>();

		for (Company company : companys) {
			CompanyEntity entity = new CompanyEntity();
			
			entity.setId(company.getId());

			 entity.setAction(company.getAction());
			 entity.setCompanyCode(company.getCompanyCode());
			 entity.setShortCode(company.getShortCode());
			 entity.setCurrencyCode(company.getCurrencyCode());
			 entity.setGlCurrencyCode(company.getGlCurrencyCode());
			 entity.setCountryCode(company.getCountryCode());
			 entity.setUserId(company.getUserId());
			 entity.setRejectCode(company.getRejectCode());
			 entity.setDescription(company.getDescription());
			 entity.setDescription2(company.getDescription2());
			 entity.setCorporateCodeId(company.getCorporateCodeId());
			 entity.setTxp(company.getTxp());
			 entity.setOtherIdType(company.getOtherIdType());
			 entity.setOtherId(company.getOtherId());
			 entity.setNonResident(company.getNonResident());
			 entity.setIssuerOfInterchange(company.getIssuerOfInterchange());
			 entity.setGlCurrencyRate(company.getGlCurrencyRate());
			 entity.setAddressLine1(company.getAddressLine1());
			 entity.setAddressLine2(company.getAddressLine2());
			 entity.setCity(company.getCity());
			 entity.setZip(company.getZip());
			 entity.setState(company.getState());
			 entity.setHomePage(company.getHomePage());
			 entity.setContactName(company.getContactName());
			 entity.setContactDepartment(company.getContactDepartment());
			 entity.setContactPhoneNumber(company.getContactPhoneNumber());
			 entity.setContactFaxNumber(company.getContactFaxNumber());
			 entity.setContactEmail(company.getContactEmail());
			 entity.setIntermediary(company.getIntermediary());
			 entity.setCounterParty(company.getCounterParty());
			 entity.setContact(company.getContact());
			 entity.setCompanyConsolidationCode(company.getCompanyConsolidationCode());
			 entity.setInterfaceCode(company.getInterfaceCode());
			 entity.setLegalForm(company.getLegalForm());
			 entity.setCapital(company.getCapital());
			 entity.setLegalRepresentative1(company.getLegalRepresentative1());
			 entity.setPosition1(company.getPosition1());
			 entity.setLegalRepresentative2(company.getLegalRepresentative2());
			 entity.setPosition2(company.getPosition2());
			 entity.setLegalFreeText1(company.getLegalFreeText1());
			 entity.setLegalFreeText2(company.getLegalFreeText2());
			 entity.setLegalFreeText3(company.getLegalFreeText3());
			 entity.setLegalFreeText4(company.getLegalFreeText4());
			 entity.setLegalFreeText5(company.getLegalFreeText5());
			 entity.setBei(company.getBei());
			 entity.setDefaultGroup(company.getDefaultGroup());
			 entity.setSepaCreditorIdentifier(company.getSepaCreditorIdentifier());
			 entity.setLei(company.getLei());
			 entity.setAccountingCalendar(company.getAccountingCalendar());
			 entity.setDistinguishedName(company.getDistinguishedName());

			entities.add(entity);
		}
		return entities;
	}

}