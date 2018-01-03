package com.wipro.customertool.data;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserEntity {
	
	@Id
	private String userId;
	

}
