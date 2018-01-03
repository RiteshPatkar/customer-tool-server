package com.wipro.customertool.data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class BankBranchEntity {
	
	@EmbeddedId
	private BankBranchEntityKey id;
	
	private String description;
}
