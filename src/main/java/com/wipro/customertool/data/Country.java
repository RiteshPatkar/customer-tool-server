package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Country {
	
	private Integer id;
	private String flag;
	private String countryCode;
	private Integer userId;
	private String CountryDescription;
	private String currencyCode;
	private Integer postalCodeLength;
	private Integer postalCodePosition;
}
