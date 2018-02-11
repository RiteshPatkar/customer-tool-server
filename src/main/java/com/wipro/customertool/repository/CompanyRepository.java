package com.wipro.customertool.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customertool.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{
	
	List<CompanyEntity> findByUserId(String userId);
	
	List<CompanyEntity> findByUserIdAndCountryCodeIn(String userId, Collection<String> countryCodes);

}