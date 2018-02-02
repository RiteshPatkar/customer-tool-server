package com.wipro.customertool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customertool.entity.CompanyEntity;
import com.wipro.customertool.entity.CompanyEntityKey;

public interface CompanyRepository extends JpaRepository<CompanyEntity, CompanyEntityKey> {
	
	List<CompanyEntity> findByIdUserIdAndIdCountryCode(String userId, String countryCode);

}
