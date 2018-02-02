package com.wipro.customertool.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BankBranchEntityKey implements Serializable{
	
	private String action;
	private String bankBranchCode;
	private String bankCode;
	private String calendarCode;
	private String countryCode;
	private String userId;
}
