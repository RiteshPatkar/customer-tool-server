package com.wipro.customertool.data;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CountryEntityKey {
	
	private String flag;
	private String countryCode;
	private String userId;
}
