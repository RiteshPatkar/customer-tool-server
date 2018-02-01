package com.wipro.customertool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customertool.entity.IsoCountryEntity;

public interface IsoCountryRepository extends JpaRepository<IsoCountryEntity, Integer>{

}
