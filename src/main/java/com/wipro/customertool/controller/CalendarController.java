package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.Calendars;
import com.wipro.customertool.service.CalendarService;

@RestController
@RequestMapping(value = "/calendar/")
public class CalendarController {

	@Autowired
	CalendarService service;

	
	@RequestMapping(value = "{userId}")
	public Calendars getCalendarsByUserId(@PathVariable(value = "userId") final String userId) {
		return service.getCalendarsByUserIdAndCountryCodes(userId, null);
	}
	
	@RequestMapping(value = "{userId}/{countryCodes}")
	public Calendars getCalendarsByUserIdAndCountryCode(@PathVariable(value = "userId") final String userId, 
			@PathVariable(value = "countryCodes") final String[] countryCodes) {
		return service.getCalendarsByUserIdAndCountryCodes(userId, countryCodes);
	}
	
	@RequestMapping(method = POST)
	public String saveCalendars(@RequestBody Calendars calendars) {
		service.saveCalendars(calendars);
		return "success";
	}
	
	@RequestMapping(value = "{id}", method = DELETE)
	public String deleteCalendarById(@PathVariable(value = "id") final Integer id) {
		service.deleteCalendarById(id);
		return "success";
	}
}
