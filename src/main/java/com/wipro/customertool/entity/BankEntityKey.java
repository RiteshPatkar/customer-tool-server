package com.wipro.customertool.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BankEntityKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String bankCode;
	private String userId;
}
