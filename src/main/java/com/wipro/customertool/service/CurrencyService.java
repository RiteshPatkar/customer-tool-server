package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.Currencies;
import com.wipro.customertool.data.Currency;
import com.wipro.customertool.entity.CurrencyEntity;
import com.wipro.customertool.repository.CurrencyRepository;

@Service
public class CurrencyService {
	
	@Autowired
	CurrencyRepository repository;
	
	public Currencies getCurrenciesByUserIdAndCountryCodes(final String userId, final String[] countryCodes) {
		
		List<CurrencyEntity> currencyEntities = null;
		
		
		if(null == countryCodes) {
			currencyEntities =  repository.findByUserId(userId);
		}
		else {
			currencyEntities =  repository.findByUserIdAndCountryCodeIn(userId, Arrays.asList(countryCodes));
		}
		return new Currencies().setUserCurrencies(buildTOFromEntites(currencyEntities));
	}

	public void saveCurrencies(Currencies input) {
		List<Currency> currencies = input.getUserCurrencies();
		List<CurrencyEntity> currencyEntities = buildEntitesFromTO(currencies);
		repository.save(currencyEntities);
	}

	public void deleteCurrencyById(Integer id) {
		repository.delete(new CurrencyEntity().setId(id));
	}
	
	private List<Currency> buildTOFromEntites(List<CurrencyEntity> entities) {
		List<Currency> currencies = new ArrayList<>();
		
		for (CurrencyEntity entity : entities) {
			Currency currency = new Currency();
			currency.setId(entity.getId());
			currency.setFlag(entity.getFlag());
			currency.setCurrencyCode(entity.getCurrencyCode());
			currency.setCountryCode(entity.getCountryCode());
			currency.setUserId(entity.getUserId());
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
			
			entity.setId(currency.getId());
			entity.setUserId(currency.getUserId());
			entity.setCountryCode(currency.getCountryCode());
			entity.setCurrencyCode(currency.getCurrencyCode());
			entity.setFlag(currency.getFlag());

			entity.setDescription(currency.getDescription());
			entity.setNumberOfDecimals(currency.getNumberOfDecimals());
			
			entities.add(entity);
		}
		return entities;
	}

}
