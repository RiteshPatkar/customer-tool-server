package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Currency {
	
	private String flag;
	private String currencyCode;
	private String countryCode;
	private String userId;
	
	private String description;
	private Integer numberOfDecimals;
}
