package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.Bank;
import com.wipro.customertool.entity.BankEntity;
import com.wipro.customertool.entity.BankEntityKey;
import com.wipro.customertool.repository.BankRepository;

@Service
public class BankService {
	
	@Autowired
	BankRepository repository;
	
	public List<Bank> getBanksByUserId(final String userId) {
		List<BankEntity> bankEntities =  repository.findByIdUserIdIgnoreCase(userId);
		return buildTOFromEntites(bankEntities);
	}

	public void saveBanksByUserId(List<Bank> banks) {
		List<BankEntity> bankEntities = buildEntitesFromTO(banks);
		repository.save(bankEntities);
	}

	public void deleteBankById(String userId, String bankCode) {
		BankEntityKey key = new BankEntityKey();
		key.setBankCode(bankCode).setUserId(userId);
		repository.delete(new BankEntity().setId(key));
	}
	
	private List<Bank> buildTOFromEntites(List<BankEntity> entities) {
		List<Bank> banks = new ArrayList<>();
		
		for (BankEntity entity : entities) {
			Bank bank = new Bank();
			bank.setBankCode(entity.getId().getBankCode());
			bank.setUserId(entity.getId().getUserId());
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
			
			BankEntityKey key = new BankEntityKey();
			key.setBankCode(bank.getBankCode());
			key.setUserId(bank.getUserId());
			
			entity.setId(key);
			entity.setDealCounterParty(bank.getDealCounterParty());
			entity.setDescription(bank.getDescription());
			entity.setDealIntermediary(bank.getDealIntermediary());
			entity.setInterCompany(bank.getInterCompany());
			
			entities.add(entity);
		}
		return entities;
	}

}
