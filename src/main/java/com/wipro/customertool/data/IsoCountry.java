package com.wipro.customertool.data;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Component
public class IsoCountry {
	
	private List<String> countryCodes;

}
