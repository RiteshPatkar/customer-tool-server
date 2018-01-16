package com.wipro.customertool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customertool.entity.CurrencyEntity;
import com.wipro.customertool.entity.CurrencyEntityKey;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, CurrencyEntityKey>{
	
	List<CurrencyEntity> findByIdUserIdAndIdCountryCode(String userId, String countryCode);
}
