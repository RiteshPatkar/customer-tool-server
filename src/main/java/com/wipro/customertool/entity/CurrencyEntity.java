package com.wipro.customertool.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class CurrencyEntity {
	
	@EmbeddedId
	private CurrencyEntityKey id;
	
	private String description;
	private Integer numberOfDecimals;
}
