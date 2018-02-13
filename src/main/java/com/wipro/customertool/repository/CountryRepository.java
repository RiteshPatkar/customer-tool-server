package com.wipro.customertool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.customertool.entity.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer>{
	
	List<CountryEntity> findByUserId(Integer userId);
	
	@Query(value="select distinct countryCode from CountryEntity c where c.flag = 'Y' AND c.userId = ?1", nativeQuery = false)
	public String[] getcountryCodesForYFlag(Integer userId);
}
