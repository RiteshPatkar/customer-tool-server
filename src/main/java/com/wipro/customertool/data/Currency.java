package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Currency {
	
	private Integer id;
	private String userId;
	private String countryCode;

	private String flag;
	private String currencyCode;
	private String description;
	private Integer numberOfDecimals;
}
