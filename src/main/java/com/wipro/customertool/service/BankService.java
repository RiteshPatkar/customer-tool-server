package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.Bank;
import com.wipro.customertool.data.Banks;
import com.wipro.customertool.entity.BankEntity;
import com.wipro.customertool.repository.BankRepository;
import com.wipro.customertool.repository.CountryRepository;

@Service
public class BankService {
	
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	public Banks getBanksByUserIdAndCountryCodes(final String userId, final String[] countryCodes) {
		
		List<BankEntity> bankEntities = null;
		
		
		if(null == countryCodes) {
			String[] retrievedCountryCodes = countryRepository.getcountryCodesForYFlag(Integer.valueOf(userId));
			if(null != retrievedCountryCodes && retrievedCountryCodes.length > 0) {
				bankEntities =  bankRepository.findByUserIdAndCountryCodeIn(userId, Arrays.asList(retrievedCountryCodes));
			} else {
				bankEntities =  bankRepository.findByUserId(userId);
			}
		}
		else {
			bankEntities =  bankRepository.findByUserIdAndCountryCodeIn(userId, Arrays.asList(countryCodes));
		}
		return new Banks().setBanks(buildTOFromEntites(bankEntities));
	}

	public void saveBanks(Banks input) {
		List<Bank> banks = input.getBanks();
		List<BankEntity> bankEntities = buildEntitesFromTO(banks);
		bankRepository.save(bankEntities);
	}

	public void deleteBankById(Integer id) {
		bankRepository.delete(new BankEntity().setId(id));
	}
	
	private List<Bank> buildTOFromEntites(List<BankEntity> entities) {
		List<Bank> banks = new ArrayList<>();
		
		for (BankEntity entity : entities) {
			Bank bank = new Bank();
			bank.setBankCode(entity.getBankCode());
			bank.setCountryCode(entity.getCountryCode());
			bank.setUserId(entity.getUserId());
			bank.setDealCounterParty(entity.getDealCounterParty());
			bank.setDescription(entity.getDescription());
			bank.setDealIntermediary(entity.getDealIntermediary());
			bank.setInterCompany(entity.getInterCompany());
			
			banks.add(bank);
		}
		return banks;
	}
	
	private List<BankEntity> buildEntitesFromTO(List<Bank> banks) {
		List<BankEntity> entities = new ArrayList<>();
		
		for (Bank bank : banks) {
			BankEntity entity = new BankEntity();
			
			entity.setId(bank.getId());
			
			entity.setCountryCode(bank.getCountryCode());
			entity.setBankCode(bank.getBankCode());
			entity.setUserId(bank.getUserId());
			entity.setDealCounterParty(bank.getDealCounterParty());
			entity.setDescription(bank.getDescription());
			entity.setDealIntermediary(bank.getDealIntermediary());
			entity.setInterCompany(bank.getInterCompany());
			
			entities.add(entity);
		}
		return entities;
	}

}
