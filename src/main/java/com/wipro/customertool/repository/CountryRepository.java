package com.wipro.customertool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customertool.entity.CountryEntity;
import com.wipro.customertool.entity.CountryEntityKey;

public interface CountryRepository extends JpaRepository<CountryEntity, CountryEntityKey>{
	
	List<CountryEntity> findByIdUserIdIgnoreCase(String userId);
}
