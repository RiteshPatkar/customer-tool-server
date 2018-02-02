package com.wipro.customertool.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BankBranchEntityKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String action;
	private String bankBranchCode;
}
