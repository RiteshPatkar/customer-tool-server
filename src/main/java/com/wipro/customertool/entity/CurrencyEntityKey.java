package com.wipro.customertool.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CurrencyEntityKey {
	
	private String flag;
	private String currencyCode;
	private String countryCode;
	private String userId;
}
