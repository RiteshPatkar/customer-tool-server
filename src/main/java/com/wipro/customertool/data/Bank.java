package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Bank {
	
	private Integer id;
	private String userId;
	private String countryCode;

	private String bankCode;
	private String description;
	private String interCompany;
	private String dealIntermediary;
	private String dealCounterParty;
}
