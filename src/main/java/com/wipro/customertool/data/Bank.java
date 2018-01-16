package com.wipro.customertool.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Bank {
	
	private String bankCode;
	private String userId;
	
	private String description;
	private String interCompany;
	private String dealIntermediary;
	private String dealCounterParty;
}
