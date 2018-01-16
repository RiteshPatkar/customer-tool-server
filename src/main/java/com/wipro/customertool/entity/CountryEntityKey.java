package com.wipro.customertool.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CountryEntityKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String flag;
	private String countryCode;
	private String userId;
}
