package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.Currency;
import com.wipro.customertool.entity.CurrencyEntity;
import com.wipro.customertool.entity.CurrencyEntityKey;
import com.wipro.customertool.repository.CurrencyRepository;

@Service
public class CurrencyService {
	
	@Autowired
	CurrencyRepository repository;
	
	public List<Currency> getCurrenciesByUserIdAndCountryCode(final String userId, final String countryCode) {
		List<CurrencyEntity> currencyEntities =  repository.findByIdUserIdAndIdCountryCode(userId, countryCode);
		return buildTOFromEntites(currencyEntities);
	}

	public void saveCurrencies(List<Currency> currencies) {
		List<CurrencyEntity> currencyEntities = buildEntitesFromTO(currencies);
		repository.save(currencyEntities);
	}

	public void deleteCurrencyById(String userId, String countryCode, String currencyCode, String flag) {
		CurrencyEntityKey key = new CurrencyEntityKey();
		key.setUserId(userId).setCountryCode(countryCode).setCurrencyCode(currencyCode).setFlag(flag);
		repository.delete(new CurrencyEntity().setId(key));
	}
	
	private List<Currency> buildTOFromEntites(List<CurrencyEntity> entities) {
		List<Currency> currencies = new ArrayList<>();
		
		for (CurrencyEntity entity : entities) {
			Currency currency = new Currency();
			
			currency.setFlag(entity.getId().getFlag());
			currency.setCurrencyCode(entity.getId().getCurrencyCode());
			currency.setCountryCode(entity.getId().getCountryCode());
			currency.setUserId(entity.getId().getUserId());
			currency.setDescription(entity.getDescription());
			currency.setNumberOfDecimals(entity.getNumberOfDecimals());
			
			currencies.add(currency);
		}
		return currencies;
	}
	
	private List<CurrencyEntity> buildEntitesFromTO(List<Currency> currencies) {
		List<CurrencyEntity> entities = new ArrayList<>();
		
		for (Currency currency : currencies) {
			CurrencyEntity entity = new CurrencyEntity();
			
			CurrencyEntityKey key = new CurrencyEntityKey();
			key.setCountryCode(currency.getCountryCode());
			key.setCurrencyCode(currency.getCurrencyCode());
			key.setFlag(currency.getFlag());
			key.setUserId(currency.getUserId());
			entity.setId(key);

			entity.setDescription(currency.getDescription());
			entity.setNumberOfDecimals(currency.getNumberOfDecimals());
			
			entities.add(entity);
		}
		return entities;
	}

}
