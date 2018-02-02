package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.Calendar;
import com.wipro.customertool.data.Company;
import com.wipro.customertool.entity.CalendarEntity;
import com.wipro.customertool.entity.CalendarEntityKey;
import com.wipro.customertool.entity.CompanyEntity;
import com.wipro.customertool.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository repository;
	
	public List<Company> getCompanyByUserIdAndCountryCode(final String userId, final String countryCode) {
		List<CompanyEntity> companyEntities =  repository.findByIdUserIdAndIdCountryCode(userId, countryCode);
		return buildTOFromEntites(calendarEntities);
	}

	public void saveCompanies(List<Company> companies) {
		List<CompanyEntity> companyEntities = buildEntitesFromTO(companies);
		repository.save(companyEntities);
	}

	public void deleteCalendarById(String userId, String countryCode, String calendarCode, String flag) {
		CalendarEntityKey key = new CalendarEntityKey();
		key.setUserId(userId).setCountryCode(countryCode).setCalendarCode(calendarCode).setFlag(flag);
		repository.delete(new CalendarEntity().setId(key));
	}
	
	private List<Calendar> buildTOFromEntites(List<CalendarEntity> entities) {
		List<Calendar> calendars = new ArrayList<>();
		
		for (CalendarEntity entity : entities) {
			Calendar calendar = new Calendar();
			
			calendar.setFlag(entity.getId().getFlag());
			calendar.setCalendarCode(entity.getId().getCalendarCode());
			calendar.setCountryCode(entity.getId().getCountryCode());
			calendar.setUserId(entity.getId().getUserId());
			calendar.setDescription(entity.getDescription());
			
			calendars.add(calendar);
		}
		return calendars;
	}
	
	private List<CalendarEntity> buildEntitesFromTO(List<Calendar> calendars) {
		List<CalendarEntity> entities = new ArrayList<>();
		
		for (Calendar calendar : calendars) {
			CalendarEntity entity = new CalendarEntity();
			
			CalendarEntityKey key = new CalendarEntityKey();
			key.setCountryCode(calendar.getCountryCode());
			key.setCalendarCode(calendar.getCalendarCode());
			key.setFlag(calendar.getFlag());
			key.setUserId(calendar.getUserId());
			entity.setId(key);

			entity.setDescription(calendar.getDescription());
			
			entities.add(entity);
		}
		return entities;
	}

}
