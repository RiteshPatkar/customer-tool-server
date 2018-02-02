package com.wipro.customertool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customertool.entity.CountryEntity;
import com.wipro.customertool.entity.CountryEntityKey;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, CountryEntityKey>{
	
	List<CountryEntity> findByIdUserIdIgnoreCase(String userId);
}
