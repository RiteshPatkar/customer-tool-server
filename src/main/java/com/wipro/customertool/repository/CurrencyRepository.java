package com.wipro.customertool.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customertool.entity.CurrencyEntity;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer>{
	
	List<CurrencyEntity> findByUserId(String userId);
	
	List<CurrencyEntity> findByUserIdAndCountryCodeIn(String userId, Collection<String> countryCodes);
}
