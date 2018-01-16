package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Country {
	
	private String flag;
	private String countryCode;
	private String userId;
	
	private String description;
	private String currencyCode;
	private Integer postalCodeLength;
	private Integer postalCodePosition;
}
