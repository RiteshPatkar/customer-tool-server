package com.wipro.customertool.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class BankEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String countryCode;
	private String bankCode;
	private String userId;
	private String description;
	private String interCompany;
	private String dealIntermediary;
	private String dealCounterParty;
}
