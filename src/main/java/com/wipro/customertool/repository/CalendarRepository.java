package com.wipro.customertool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customertool.entity.CalendarEntity;
import com.wipro.customertool.entity.CalendarEntityKey;

public interface CalendarRepository extends JpaRepository<CalendarEntity, CalendarEntityKey>{
	
	List<CalendarEntity> findByIdUserIdAndIdCountryCode(String userId, String countryCode);
}
