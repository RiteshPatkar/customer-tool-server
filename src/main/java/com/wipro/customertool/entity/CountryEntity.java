package com.wipro.customertool.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class CountryEntity {
	
	@EmbeddedId
	private CountryEntityKey id;
	
	private String flag;
	private String description;
	private String currencyCode;
	private Integer postalCodeLength;
	private Integer postalCodePosition;
}
