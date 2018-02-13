package com.wipro.customertool.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(Include.NON_EMPTY)
public class Currencies {
	
	private List<Currency> currencies;
//	private List<String> isoCountryCodes;

}
