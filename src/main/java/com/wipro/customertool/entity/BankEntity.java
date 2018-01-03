package com.wipro.customertool.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class BankEntity {
	
	@EmbeddedId
	private BankEntityKey id;
	
	private String description;
	private String interCompany;
	private String dealIntermediary;
	private String dealCounterParty;
}
