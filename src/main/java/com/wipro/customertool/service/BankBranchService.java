package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.BankBranch;
import com.wipro.customertool.data.BankBranches;
import com.wipro.customertool.entity.BankBranchEntity;
import com.wipro.customertool.repository.BankBranchRepository;
import com.wipro.customertool.repository.CountryRepository;

@Service
public class BankBranchService {
	
	@Autowired
	BankBranchRepository bankBranchRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	public BankBranches getBankBranchesByUserIdAndCountryCodes(final String userId, final String[] countryCodes) {
		
		List<BankBranchEntity> bankBranchEntities = null;
		
		
		if(null == countryCodes) {
			String[] retrievedCountryCodes = countryRepository.getcountryCodesForYFlag(Integer.valueOf(userId));
			if(null != retrievedCountryCodes && retrievedCountryCodes.length > 0) {
				bankBranchEntities =  bankBranchRepository.findByUserIdAndCountryCodeIn(userId, Arrays.asList(retrievedCountryCodes));
			} else {
				bankBranchEntities =  bankBranchRepository.findByUserId(userId);
			}
		}
		else {
			bankBranchEntities =  bankBranchRepository.findByUserIdAndCountryCodeIn(userId, Arrays.asList(countryCodes));
		}
		return new BankBranches().setBankBranches(buildTOFromEntites(bankBranchEntities));
	}

	public void saveBankBranches(BankBranches input) {
		List<BankBranch> bankBranches = input.getBankBranches();
		List<BankBranchEntity> bankBranchEntities = buildEntitesFromTO(bankBranches);
		bankBranchRepository.save(bankBranchEntities);
	}

	public void deleteBankBranchById(Integer id) {
		bankBranchRepository.delete(new BankBranchEntity().setId(id));
	}
	
	
	
	private List<BankBranch> buildTOFromEntites(List<BankBranchEntity> entities) {
		List<BankBranch> bankBranches = new ArrayList<>();
		
		for (BankBranchEntity entity : entities) {
			BankBranch bankBranch = new BankBranch();
			bankBranch.setId(entity.getId());
			bankBranch.setBankBranchCode(entity.getBankBranchCode());
			bankBranch.setAction(entity.getAction());
			bankBranch.setBankCode(entity.getBankCode());
			bankBranch.setCalendarCode(entity.getCalendarCode());
			bankBranch.setCountryCode(entity.getCountryCode());
			bankBranch.setUserId(entity.getUserId());
			bankBranch.setDescription(entity.getDescription());
			bankBranch.setDescription2(entity.getDescription2());
			bankBranch.setIntercompany(entity.getIntercompany());
			bankBranch.setMainBranchOfCountry(entity.getMainBranchOfCountry());
			bankBranch.setAccountLocation(entity.getAccountLocation());
			bankBranch.setBic(entity.getBic());
			bankBranch.setCorpIdCode(entity.getCorpIdCode());
			bankBranch.setCorpIdType(entity.getCorpIdType());
			bankBranch.setOtherId(entity.getOtherId());
			bankBranch.setIntermediary(entity.getIntermediary());
			bankBranch.setAddressLine1(entity.getAddressLine1());
			bankBranch.setAddressLine2(entity.getAddressLine2());
			bankBranch.setCity(entity.getCity());
			bankBranch.setZip(entity.getZip());
			bankBranch.setState(entity.getState());
			bankBranch.setHomePage(entity.getHomePage());
			bankBranch.setBankContactName(entity.getBankContactName());
			bankBranch.setBankcontactDepartment(entity.getBankcontactDepartment());
			bankBranch.setBankcontactPhone(entity.getBankcontactPhone());
			bankBranch.setBankcontactFax(entity.getBankcontactFax());
			bankBranch.setBankcontactEmail(entity.getBankcontactEmail());
			bankBranch.setInterfaceCode(entity.getInterfaceCode());
			bankBranch.setResponderCode(entity.getResponderCode());
			bankBranch.setServiceName(entity.getServiceName());
			bankBranch.setUserZone1(entity.getUserZone1());
			bankBranch.setUserZone2(entity.getUserZone2());
			bankBranch.setUserZone3(entity.getUserZone3());
			bankBranch.setUserZone4(entity.getUserZone4());
			bankBranch.setUserZone5(entity.getUserZone5());
			bankBranch.setMemo(entity.getMemo());
			
			
			bankBranches.add(bankBranch);
		}
		return bankBranches;
	}
	
	private List<BankBranchEntity> buildEntitesFromTO(List<BankBranch> bankBranches) {
		List<BankBranchEntity> entities = new ArrayList<>();
		
		for (BankBranch bankBranch : bankBranches) {
			BankBranchEntity entity = new BankBranchEntity();
			
			entity.setId(bankBranch.getId());
			
			entity.setBankBranchCode(bankBranch.getBankCode());
			entity.setAction(bankBranch.getAction());
			entity.setBankCode(bankBranch.getBankCode());
			entity.setCalendarCode(bankBranch.getCalendarCode());
			entity.setCountryCode(bankBranch.getCountryCode());
			entity.setUserId(bankBranch.getUserId());
			entity.setDescription(bankBranch.getDescription());
			entity.setDescription2(bankBranch.getDescription2());
			entity.setIntercompany(bankBranch.getIntercompany());
			entity.setMainBranchOfCountry(bankBranch.getMainBranchOfCountry());
			entity.setAccountLocation(bankBranch.getAccountLocation());
			entity.setBic(bankBranch.getBic());
			entity.setCorpIdCode(bankBranch.getCorpIdCode());
			entity.setCorpIdType(bankBranch.getCorpIdType());
			entity.setOtherId(bankBranch.getOtherId());
			entity.setIntermediary(bankBranch.getIntermediary());
			entity.setAddressLine1(bankBranch.getAddressLine1());
			entity.setAddressLine2(bankBranch.getAddressLine2());
			entity.setCity(bankBranch.getCity());
			entity.setZip(bankBranch.getZip());
			entity.setState(bankBranch.getState());
			entity.setHomePage(bankBranch.getHomePage());
			entity.setBankContactName(bankBranch.getBankContactName());
			entity.setBankcontactDepartment(bankBranch.getBankcontactDepartment());
			entity.setBankcontactPhone(bankBranch.getBankcontactPhone());
			entity.setBankcontactFax(bankBranch.getBankcontactFax());
			entity.setBankcontactEmail(bankBranch.getBankcontactEmail());
			entity.setInterfaceCode(bankBranch.getInterfaceCode());
			entity.setResponderCode(bankBranch.getResponderCode());
			entity.setServiceName(bankBranch.getServiceName());
			entity.setUserZone1(bankBranch.getUserZone1());
			entity.setUserZone2(bankBranch.getUserZone2());
			entity.setUserZone3(bankBranch.getUserZone3());
			entity.setUserZone4(bankBranch.getUserZone4());
			entity.setUserZone5(bankBranch.getUserZone5());
			entity.setMemo(bankBranch.getMemo());
			
			entities.add(entity);
		}
		return entities;
	}

}
