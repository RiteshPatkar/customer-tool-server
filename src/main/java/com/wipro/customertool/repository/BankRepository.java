package com.wipro.customertool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customertool.entity.BankEntity;
import com.wipro.customertool.entity.BankEntityKey;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, BankEntityKey>{
	
	List<BankEntity> findByIdUserIdIgnoreCase(String userId);
}