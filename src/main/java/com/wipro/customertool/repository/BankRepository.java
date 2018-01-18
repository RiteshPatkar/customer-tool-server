package com.wipro.customertool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customertool.entity.BankEntity;
import com.wipro.customertool.entity.BankEntityKey;

public interface BankRepository extends JpaRepository<BankEntity, BankEntityKey>{
	
	List<BankEntity> findByIdUserIdIgnoreCase(String userId);
}