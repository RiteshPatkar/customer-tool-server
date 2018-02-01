package com.wipro.customertool.entity;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class IsoCountryEntity {

	@Id
	private Integer id;
	private String countryCode;
	private String countryDescription;
}
