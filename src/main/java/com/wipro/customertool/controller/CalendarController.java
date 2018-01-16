package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.Calendar;
import com.wipro.customertool.service.CalendarService;

@RestController
@RequestMapping(value = "/calendar/")
public class CalendarController {

	@Autowired
	CalendarService service;

	
	@RequestMapping(value = "{userId}/{countryCode}")
	public List<Calendar> getCalendarsByUserIdAndCountryCode(@PathVariable(value = "userId") final String userId, 
			@PathVariable(value = "countryCode") final String countryCode) {
		return service.getCalendarByUserIdAndCountryCode(userId, countryCode);
	}
	
	@RequestMapping(method = POST)
	public String saveCalendars(@RequestBody List<Calendar> calendars) {
		service.saveCalendars(calendars);
		return "success";
	}
	
	@RequestMapping(value = "{userId}/{countryCode}/{calendarCode}/{flag}", method = DELETE)
	public String deleteCalendarById(@PathVariable(value = "userId") final String userId,
			@PathVariable(value = "countryCode") final String countryCode,
			@PathVariable(value = "calendarCode") final String calendarCode,
			@PathVariable(value = "flag") final String flag) {
		service.deleteCalendarById(userId, countryCode, calendarCode, flag);
		return "success";
	}
}
