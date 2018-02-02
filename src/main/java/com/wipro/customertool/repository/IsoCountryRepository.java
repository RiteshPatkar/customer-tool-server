package com.wipro.customertool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customertool.entity.IsoCountryEntity;

@Repository
public interface IsoCountryRepository extends JpaRepository<IsoCountryEntity, Integer>{

}
