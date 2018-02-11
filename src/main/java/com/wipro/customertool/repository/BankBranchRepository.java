package com.wipro.customertool.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customertool.entity.BankBranchEntity;

public interface BankBranchRepository extends JpaRepository<BankBranchEntity, Integer>{
	
	List<BankBranchEntity> findByUserId(String userId);
	
	List<BankBranchEntity> findByUserIdAndCountryCodeIn(String userId, Collection<String> countryCodes);
}