package com.wipro.customertool.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CompanyEntityKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String action;
	private String companyCode;
	private String shortCode;
	private String userId;
}
