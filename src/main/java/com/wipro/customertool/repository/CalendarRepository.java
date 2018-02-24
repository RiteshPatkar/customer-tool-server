package com.wipro.customertool.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customertool.entity.CalendarEntity;

@Repository
public interface CalendarRepository extends JpaRepository<CalendarEntity, Integer> {
	
	List<CalendarEntity> findByUserId(String userId);
	
	List<CalendarEntity> findByUserIdAndCountryCodeIn(String userId, Collection<String> countryCodes);
}
