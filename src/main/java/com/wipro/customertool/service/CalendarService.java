package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.BankHoliday;
import com.wipro.customertool.data.Calendar;
import com.wipro.customertool.data.Calendars;
import com.wipro.customertool.entity.BankHolidayEntity;
import com.wipro.customertool.entity.CalendarEntity;
import com.wipro.customertool.repository.CalendarRepository;
import com.wipro.customertool.repository.CountryRepository;

@Service
public class CalendarService {
	
	@Autowired
	CalendarRepository calendarRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	public Calendars getCalendarsByUserIdAndCountryCodes(final String userId, final String[] countryCodes) {
		
		List<CalendarEntity> calendarEntities = null;
		
		
		if(null == countryCodes) {
			String[] retrievedCountryCodes = countryRepository.getcountryCodesForYFlag(Integer.valueOf(userId));
			if(null != retrievedCountryCodes && retrievedCountryCodes.length > 0) {
				calendarEntities =  calendarRepository.findByUserIdAndCountryCodeIn(userId, Arrays.asList(retrievedCountryCodes));
			} else {
				calendarEntities =  calendarRepository.findByUserId(userId);
			}
		}
		else {
			calendarEntities =  calendarRepository.findByUserIdAndCountryCodeIn(userId, Arrays.asList(countryCodes));
		}
		return new Calendars().setCalendars(buildTOFromEntites(calendarEntities));
	}

	public void saveCalendars(Calendars input) {
		List<Calendar> calendars = input.getCalendars();
		List<CalendarEntity> calendarEntities = buildEntitesFromTO(calendars);
		calendarRepository.save(calendarEntities);
	}

	public void deleteCalendarById(Integer id) {
		calendarRepository.delete(new CalendarEntity().setId(id));
	}
	
	private List<Calendar> buildTOFromEntites(List<CalendarEntity> entities) {
		List<Calendar> calendars = new ArrayList<>();
		
		for (CalendarEntity entity : entities) {
			Calendar calendar = new Calendar();
			calendar.setId(entity.getId());
			calendar.setCalendarCode(entity.getCalendarCode());
			calendar.setCountryCode(entity.getCountryCode());
			calendar.setUserId(entity.getUserId());
			calendar.setCalendarDescription(entity.getCalendarDescription());
			calendar.setClosedDays(entity.getClosedDays());
			
			List<BankHoliday> bankHolidays = new ArrayList<>();
			for(BankHolidayEntity holidayEntity : entity.getDatesAndFlags()) {
				BankHoliday bankHoliday = new BankHoliday();
				bankHoliday.setId(holidayEntity.getId());
				bankHoliday.setDate(holidayEntity.getDate());
				bankHoliday.setFlag(holidayEntity.getFlag());
				bankHolidays.add(bankHoliday);
			}
			
			calendar.setDatesAndFlags(bankHolidays);
			
			calendars.add(calendar);
		}
		return calendars;
	}
	
	private List<CalendarEntity> buildEntitesFromTO(List<Calendar> calendars) {
		List<CalendarEntity> entities = new ArrayList<>();
		
		for (Calendar calendar : calendars) {
			CalendarEntity entity = new CalendarEntity();
			entity.setId(calendar.getId());
			entity.setCountryCode(calendar.getCalendarCode());
			entity.setCalendarCode(calendar.getCalendarCode());
			entity.setUserId(calendar.getUserId());
			entity.setCalendarDescription(calendar.getCalendarDescription());
			entity.setClosedDays(calendar.getClosedDays());
			
			List<BankHolidayEntity> bankHolidayEntities = new ArrayList<>();
			for(BankHoliday bankHoliday : calendar.getDatesAndFlags()) {
				BankHolidayEntity holidayEntity = new BankHolidayEntity();
				holidayEntity.setId(bankHoliday.getId());
//				holidayEntity.setCalendarId(calendar.getId());
				holidayEntity.setDate(bankHoliday.getDate());
				holidayEntity.setFlag(bankHoliday.getFlag());
				bankHolidayEntities.add(holidayEntity);
			}
			
			entity.setDatesAndFlags(bankHolidayEntities);
			
			entities.add(entity);
		}
		return entities;
	}

}
