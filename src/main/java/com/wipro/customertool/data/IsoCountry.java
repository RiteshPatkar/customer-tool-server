package com.wipro.customertool.data;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Component
public class IsoCountry {
	
	private String countryCode;
	private String countryDescription;

}
