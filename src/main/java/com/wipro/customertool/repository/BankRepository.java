package com.wipro.customertool.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customertool.entity.BankEntity;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, Integer>{
	
	List<BankEntity> findByUserId(String userId);
	
	List<BankEntity> findByUserIdAndCountryCodeIn(String userId, Collection<String> countryCodes);
}