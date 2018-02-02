package com.wipro.customertool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customertool.entity.BankBranchEntity;
import com.wipro.customertool.entity.BankBranchEntityKey;

public interface BankBranchRepository extends JpaRepository<BankBranchEntity, BankBranchEntityKey>{
	
	List<BankBranchEntity> findByBankCodeIgnoreCase(String userId);
}