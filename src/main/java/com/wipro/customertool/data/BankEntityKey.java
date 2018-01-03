package com.wipro.customertool.data;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BankEntityKey {
	
	private String bankCode;
	private String userId;
}
